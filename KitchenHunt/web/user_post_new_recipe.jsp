<%-- 
    Document   : user_post_new_recipe
    Created on : Jun 12, 2016, 12:19:37 PM
    Author     : User
--%>

<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="HibFiles.Notification"%>
<%@page import="HibFiles.Unit"%>
<%@page import="HibFiles.HealthCategory"%>
<%@page import="HibFiles.CuisineCategory"%>
<%@page import="java.util.List"%>
<%@page import="HibFiles.FoodCategory"%>
<%@page import="org.hibernate.Criteria"%>
<!DOCTYPE html>
<%@page import="HibFiles.User"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
<%@page import="HibFiles.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <title>Kitchen Hunt - Post a new Recipe</title>

        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            request.getSession().removeAttribute("recipeList");

            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } else {
                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                Session s = PoolManager.getSessionFactory().openSession();
                User us = (User) s.load(User.class, ul.getUser().getIduser());
        %>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Other scripts -->
        <link href="css/sidebar.css" rel="stylesheet">
        <link href="css/mycss.css" rel="stylesheet">
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/footer-distributed.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/myjavascript.js"></script>

        <script>
            function post(frm1) {
                correct = true;

                if (document.getElementById("recipe_skill").value == "") {
                    correct = false;
                }
                if (document.getElementById("recipe_mealtype").value == "") {
                    correct = false;
                }
                if (document.getElementById("recipe_healthcat").value == "") {
                    correct = false;
                }
                if (document.getElementById("recipe_cuisine").value == "") {
                    correct = false;
                }
                if (document.getElementById("images").value == "") {
                    correct = false;
                }

                if (correct) {
                    document.form("recipeform").submit();
                } else {
                    alert("Make sure you have filled all the fields");
                }
            }
        </script>

    </head>
    <body>

        <!--Beginning of navigation bar-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header" style="font-family: Precious">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<img alt="Brand" src="images/KitchenHunt.png" height="32" width="auto">-->
                    <a class="navbar-brand" href="index.jsp">Kitchen Hunt</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="recipe_search.jsp">Recipe Search</a></li>
                        <li><a href="#">Help</a></li>
                        <li><a id="idabout" href="about.jsp">About</a></li>

                        <%
                            if (request.getSession().getAttribute("user") != null) {
                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getFname()%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="user_dashboard.jsp">My Kitchen Dashboard</a></li>
                                <li><a href="add_new_recipe.jsp">Post Recipe</a></li>
                                <li><a href="SignOut">Sign Out</a></li>
                            </ul>
                        </li>

                        <%}%>


                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!--End of navigation bar-->



        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                    <!-- Left column -->
                    <strong><i class="glyphicon glyphicon-wrench"></i> Tools</strong>

                    <hr>

                    <ul class="nav nav-stacked">
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu"><strong>Recipes</strong></a>
                            <ul class="nav nav-stacked collapse in" id="userMenu">
                                <li class="active"><a href="user_recipes.jsp">My Recipes</a></li>
                                <li><a href="user_post_new_recipe.jsp">Post New Recipe <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                                <li><a href="user_ingredients.jsp">My Ingredients</a></li>
                                <li><a href="user_add_new_category.jsp">Add New Category</a></li>

                                <%

                                    Criteria c = s.createCriteria(Notification.class);
                                    c.add(Restrictions.eq("user", us));
                                    List<Notification> n_list = c.list();

                                    int len = n_list.size();
                                %>

                                <li><a href="user_notifications.jsp">Notifications <span class="badge badge-info"><%=len%></span></a></li>

                            </ul>
                        </li>
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2"><strong>Account</strong></a>

                            <ul class="nav nav-stacked collapse" id="menu2">
                                <li><a href="user_profile.jsp">My Profile</a></li>
                                <li><a href="#">Change Password</a></li>
                                <li><a href="SignOut">Sign Out</a></li>
                            </ul>
                        </li>

                    </ul>

                    <hr>

                </div>
                <!-- /col-3 -->
                <div class="col-sm-9">

                    <!-- column 2 -->

                    <strong><i class="glyphicon glyphicon-dashboard"></i> My Kitchen Dashboard</strong>
                    <hr>


                    <%
                        if (request.getParameter("msg") != null) {
                            if (request.getParameter("msg").equals("success")) {
                    %>
                    <div class="alert alert-success fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Success!</strong> Recipe posted successfully.
                    </div>

                    <%} else if (request.getParameter("msg").equals("exists")) {%>
                    <div class="alert alert-warning fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Duplicate!</strong> Recipe entered already exists.
                    </div>

                    <%  } else if (request.getParameter("msg").equals("error")) {%>
                    <div class="alert alert-danger fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> An error occurred while posting your recipe.
                    </div>
                    <%}
                        }%>

                    <!--Post a new recipe form-->
                    <div class="container">
                        <div align="center">
                            <h1><small>Post a New Recipe</small></h1>
                        </div>
                    </div>

                    <br>

                    <form class="form-horizontal" role="form" method="POST" action="PostRecipe" onsubmit="post(this); return false;" enctype="multipart/form-data" id="recipeform">
                        <div style="width:70%; margin:0 auto;">
                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Recipe Name:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="recipe_name" name="recipe_name" placeholder="" value="" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Skill Level:</label>
                                <div class="col-sm-9">

                                    <select name="recipe_skill" id="recipe_skill" class="form-control" >
                                        <option value="">Select Skill Level</option>
                                        <option value="Beginner">Beginner</option>
                                        <option value="Moderate">Moderate</option>
                                        <option value="Expert">Expert</option>
                                    </select>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Serving Quantity:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="recipe_qty" name="recipe_qty" placeholder="" value="" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Preparation Time:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="recipe_preptime" name="recipe_preptime" placeholder="" value="" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Meal Type:</label>
                                <div class="col-sm-9">
                                    <select name="recipe_mealtype" id="recipe_mealtype" class="form-control" >
                                        <option value="">Select Meal Type</option>
                                        <%
                                            Criteria c1 = s.createCriteria(FoodCategory.class);
                                            List<FoodCategory> lfc = c1.list();
                                            for (FoodCategory fc : lfc) {
                                        %>
                                        <option value="<%=fc.getIdfoodCategory()%>"><%=fc.getCategoryName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Cuisine Style:</label>
                                <div class="col-sm-9">
                                    <select name="recipe_cuisine" id="recipe_cuisine" class="form-control" >
                                        <option value="">Select Cuisine Style</option>
                                        <%
                                            Criteria c2 = s.createCriteria(CuisineCategory.class);
                                            List<CuisineCategory> lcs = c2.list();
                                            for (CuisineCategory cc : lcs) {
                                        %>
                                        <option value="<%=cc.getIdcuisineCategory()%>"><%=cc.getCuisineName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3" disabled>Health Category:</label>
                                <div class="col-sm-9">
                                    <select name="recipe_healthcat" id="recipe_healthcat" class="form-control" >
                                        <option value="">Select Health Category</option>
                                        <%
                                            Criteria c3 = s.createCriteria(HealthCategory.class);
                                            List<HealthCategory> lhc = c3.list();
                                            for (HealthCategory hc : lhc) {
                                        %>
                                        <option value="<%=hc.getIdhealthCategory()%>"><%=hc.getCategoryName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3" disabled>Upload Image</label>
                                <div class="col-sm-9" id="main">
                                    <form method="post" enctype="multipart/form-data">
                                        <input class="form-control" type="file" name="imagesn" id="images" max-uploads=1/>
                                        <button class="btn btn-success" type="submit" id="btn"></button>
                                    </form>
                                    <ul id="image-list"></ul>
                                    <div id="btn-clear-div" align="right"></div>
                                </div>
                                <script src="js/jquery-1.10.2.min.js"></script>
                                <script src="js/upload.js"></script>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <h2><small>Ingredients</small></h2>
                                </div>
                                <div class="col-sm-9"></div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 1:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing1" name="recipe_ing1" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing1_qty" name="recipe_ing1_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing1_unit" id="recipe_ing1_unit" class="form-control" >
                                        <%
                                            Criteria cu1 = s.createCriteria(Unit.class);
                                            List<Unit> lu1 = cu1.list();
                                            for (Unit u : lu1) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 2:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing2" name="recipe_ing2" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing2_qty" name="recipe_ing2_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing2_unit" id="recipe_ing2_unit" class="form-control" >
                                        <%
                                            Criteria cu2 = s.createCriteria(Unit.class);
                                            List<Unit> lu2 = cu2.list();
                                            for (Unit u : lu2) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 3:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing3" name="recipe_ing3" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing3_qty" name="recipe_ing3_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing3_unit" id="recipe_ing3_unit" class="form-control" >
                                        <%
                                            Criteria cu3 = s.createCriteria(Unit.class);
                                            List<Unit> lu3 = cu3.list();
                                            for (Unit u : lu3) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 4:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing4" name="recipe_ing4" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing4_qty" name="recipe_ing4_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing4_unit" id="recipe_ing4_unit" class="form-control" >
                                        <%
                                            Criteria cu4 = s.createCriteria(Unit.class);
                                            List<Unit> lu4 = cu4.list();
                                            for (Unit u : lu4) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 5:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing5" name="recipe_ing5" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing5_qty" name="recipe_ing5_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing5_unit" id="recipe_ing5_unit" class="form-control" >
                                        <%
                                            Criteria cu5 = s.createCriteria(Unit.class);
                                            List<Unit> lu5 = cu5.list();
                                            for (Unit u : lu5) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-sm-3" disabled>Ingredient 6:</label>

                                <div class="col-xs-4 col-md-4">
                                    <input type="text" class="form-control" id="recipe_ing6" name="recipe_ing6" placeholder="Ingredient Name" value="">
                                </div>
                                <div class="col-xs-3 col-md-3">
                                    <input type="text" class="form-control" id="recipe_ing6_qty" name="recipe_ing6_qty" placeholder="Quantity" value="">

                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <select name="recipe_ing6_unit" id="recipe_ing6_unit" class="form-control" >
                                        <%
                                            Criteria cu6 = s.createCriteria(Unit.class);
                                            List<Unit> lu6 = cu6.list();
                                            for (Unit u : lu6) {
                                        %>
                                        <option value="<%=u.getIdunit()%>"><%=u.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <h2><small>Directions</small></h2>
                                </div>
                                <div class="col-sm-9">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                </div>
                                <div class="col-sm-9">
                                    <textarea class="form-control" rows="10" name="recipe_directions" id="recipe_directions"></textarea>
                                </div>
                            </div>


                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-10" align="right" id="action_button">
                                    <h1><input type="submit" value="Save Recipe" class="btn btn-success"/></h1>

                                </div>
                            </div>
                        </div>
                    </form>


                    <br><br><br><br><br><br>




                </div>
                <!--/col-span-9-->
            </div>
        </div>
        <!-- /Main -->




        <!--Beginning of footer-->
        <footer class="footer-distributed">

            <div class="footer-right">

                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-github"></i></a>

            </div>

            <div class="footer-left">

                <p class="footer-links">
                    <a href="#">Home</a>
                    ·
                    <a href="#">Recipe Search</a>
                    ·
                    <a href="#">Help</a>
                    ·
                    <a href="#">About</a>
                    ·
                    <a href="#">My Kitchen</a>
                    ·
                    <a href="#">Contact</a>
                </p>

                <p>Kitchen Hunt &copy; 2016</p>
            </div>

        </footer>
        <!--End of footer-->

        <%}%>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="js/sidebar.js"></script>
</html>
