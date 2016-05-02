<%-- 
    Document   : post_request
    Created on : May 2, 2016, 2:29:05 PM
    Author     : User
--%>

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
        <title>Kitchen Hunt - Request Recipe</title>

        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } else {
                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                Session s = PoolManager.getSessionFactory().openSession();
        %>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Other scripts -->
        <link href="css/sidebar.css" rel="stylesheet">
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/footer-distributed.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/myjavascript.js"></script>


    </head>
    <body>

        <!--Beginning of navigation bar-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <!--<img alt="Brand" src="images/KitchenHunt.png" height="32" width="auto">-->
                        <a class="navbar-brand" href="index.jsp">Kitchen Hunt</a>
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="recipe_search.jsp">Recipe Search</a></li>
                        <li><a href="#">Help</a></li>
                        <li><a href="#">About</a></li>

                        <%
                            if (request.getSession().getAttribute("user") != null) {

                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getFname()%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="profile.jsp">Profile</a></li>
                                <li><a href="add_new_recipe.jsp">Post Recipe</a></li>
                                <li><a href="SignOut">Sign Out</a></li>
                            </ul>
                        </li>

                        <%} else {%>

                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> My Kitchen<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal" data-target="#signUpModal">Sign Up</a></li>
                                <li><a href="#" data-toggle="modal" data-target="#signInModal">Sign In</a></li>
                            </ul>
                        </li>
                        <%}%>

                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!--End of navigation bar-->

        <!-- Sign Up Modal -->
        <div id="signUpModal" class="modal fade" role="dialog" align="center">
            <div class="modal-dialog" >

                <!-- Modal content-->
                <div class="modal-content modal-sm"  >
                    <div class="modal-header" style="text-align: center">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Sign Up</h3>
                    </div>
                    <div class="modal-body" align="left">
                        <form role="form" action="" onsubmit="signUp(this); return false;" method="POST" id="testform">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="name" class="form-control" name="signup_name" id="idname" required>
                            </div>
                            <div class="form-group">
                                <label for="name">Mobile:</label>
                                <input type="number" class="form-control" name="signup_mobile" id="idmobile" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <input type="email" class="form-control" name="signup_email" id="idemail" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" name="signup_password" id="idpassword" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Confirm password:</label>
                                <input type="password" class="form-control" name="signup_confirmpassword" id="idconfirmpassword" required>
                            </div>
                            <div align="right">
                                <input type="submit" value="Sign Up" class="btn btn-success btn-block"/>
                            </div>
                        </form>

                    </div>

                </div>

            </div>
        </div>

        <!-- Sign In Modal -->
        <div id="signInModal" class="modal fade" role="dialog" align="center">
            <div class="modal-dialog" >

                <!-- Modal content-->
                <div class="modal-content modal-sm"  >
                    <div class="modal-header" style="text-align: center">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Sign In</h3>
                    </div>
                    <div class="modal-body" align="left">
                        <form role="form" action="" onsubmit="signIn(this); return false;" method="POST" id="testform">
                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <input type="email" class="form-control" name="signin_email" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" name="signin_password" required>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                            <div align="right">
                                <input type="submit" value="Sign In" class="btn btn-success btn-block"/>
                            </div>
                        </form>

                    </div>

                </div>

            </div>
        </div>

        <!--Request a new recip form-->
        <div class="container">
            <div class="page-header" align="center">
                <h1><small>Request a Recipe</small></h1>
            </div>
        </div>

        <div style="width:50%; margin:0 auto;">
            <form class="form-horizontal" role="form" onsubmit="postRequest(this); return false;" method="POST" id="testform">
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
                            <option value="">---Select Skill Level---</option>
                            <option value="Beginner">Beginner</option>
                            <option value="Moderate">Moderate</option>
                            <option value="Expert">Expert</option>
                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" disabled>Serving Quantity:</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="recipe_qty" name="recipe_qty" placeholder="" value="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" disabled>Preparation Time:</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="recipe_preptime" name="recipe_preptime" placeholder="" value="">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-3" disabled>Meal Type:</label>
                    <div class="col-sm-9">
                        <select name="recipe_mealtype" id="recipe_mealtype" class="form-control" >
                            <option value="">---Select Meal Type---</option>
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
                        <select name="recipe_cusine" id="recipe_cuisine" class="form-control" >
                            <option value="">---Select Cuisine Style---</option>
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
                            <option value="">---Select Health Category---</option>
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
                            <option value="g">g</option>
                            <option value="tbs">tbs</option>
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
                            <option value="g">g</option>
                            <option value="tbs">tbs</option>
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
                            <option value="g">g</option>
                            <option value="tbs">tbs</option>
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
                            <option value="g">g</option>
                            <option value="tbs">tbs</option>
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

            </form>
        </div>

        <br><br><br><br><br><br>

        
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

