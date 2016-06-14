<%-- 
    Document   : recipe_search
    Created on : Apr 6, 2016, 8:34:05 PM
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="HibFiles.Ingredient"%>
<%@page import="HibFiles.HealthCategory"%>
<%@page import="HibFiles.CuisineCategory"%>
<%@page import="HibFiles.FoodCategory"%>
<%@page import="HibFiles.Image"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="HibFiles.Recipe"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="HibFiles.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <title>Kitchen Hunt - Search</title>

        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

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
        <link rel="stylesheet" href="css/jquery-ui.css" />

        <script type="text/javascript" src="js/myjavascript.js"></script>
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/jquery-ui.js"></script>

        <!--Script for auto-complete search-->
        <script type="text/javascript">
            $(function () {

            <%
                Criteria c11 = s.createCriteria(Recipe.class);
                c11.addOrder(Order.asc("idrecipe"));
                List<Recipe> lr1 = c11.list();
            %>
                var availableTags = [
            <%
                for (Recipe r : lr1) {
            %>
                    "<%=r.getName()%>",
            <%}%>
                ];
                $("#tags").autocomplete({
                    source: availableTags
                });
            });
        </script>


    </head>
    <body>

        <!--Beginning of navigation bar-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<img alt="Brand" src="images/KitchenHunt.png" height="32" width="auto">-->
                    <a class="navbar-brand" href="index.jsp">
                        <img alt="Kitchen Hunt" src="images/KitchenHunt.png" height="28" width="auto">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="recipe_search.jsp">Recipe Search</a></li>
                        <li><a href="help.jsp">Help</a></li>
                        <li><a id="idabout" href="about.jsp">About</a></li>
                        <li><a id="idcontact" href="contact_us.jsp">Contact Us</a></li>

                        <%
                            if (request.getSession().getAttribute("user") != null) {
                                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getFname()%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="user_dashboard.jsp">My Kitchen Dashboard</a></li>
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

                <%
                    Cookie[] cookies = request.getCookies();
                    String email = "", pass = "";
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("cookieLoginUser")) {
                                email = cookie.getValue();
                            }
                            if (cookie.getName().equals("cookieLoginPassword")) {
                                pass = cookie.getValue();
                            }
                        }
                    }
                %>

                <!-- Modal content-->
                <div class="modal-content modal-sm"  >
                    <div class="modal-header" style="text-align: center">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Sign In</h3>
                    </div>
                    <div class="modal-body" align="left">
                        <form role="form" action="" onsubmit="signIn(this); return false;" method="POST" id="signin_form">
                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <input type="email" class="form-control" name="signin_email" value="<%=email%>" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" name="signin_password" value="<%=pass%>" required>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" id="rememberMe"> Remember me</label>
                            </div>
                            <div align="right">
                                <input type="submit" value="Sign In" class="btn btn-success btn-block"/>
                            </div>
                        </form>

                    </div>

                </div>

            </div>
        </div>


        <!--Beginning of recipe search sidebar-->
        <div class="container-fluid" style="width:98%; margin:0 auto;">
            <div class="row content">
                <div class="col-sm-3 sidenav">

                    <!--<div class="input-group">
                        <input type="text" class="form-control" placeholder="Search Kitchen Hunt...">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>-->

                    <!--Auto-complete search input-->

                    <form action="GeneralSearch" method="POST">
                        <div class="form-group">
                            <input type="text" name="search" id="tags" class="form-control" placeholder="Search Kitchen Hunt..."/>
                        </div>

                        <div class="form-group">
                            <button class="btn btn-default btn-block" type="submit">
                                <span class="glyphicon glyphicon-search"></span> Search Kitchen Hunt 
                            </button>
                        </div>
                    </form>

                    <hr>

                    <form role="form" action="RecipeSearch" method="POST" id="testform">

                        <!--Enter ingredient to include-->
                        <div class="form-group">
                            <label class="control-label" for="email">Ingredient to include</label>
                            <input type="text" name="recipe_inc_ing" id="recipe_inc_ing" class="form-control" placeholder=""/>
                        </div>

                        <!--Enter ingredient to exclude-->
                        <div class="form-group">
                            <label class="control-label" for="email">Ingredient to exclude</label>
                            <input type="text" name="recipe_ex_ing" id="recipe_ex_ing" class="form-control" placeholder=""/>
                        </div>

                        <!--Select meal type-->
                        <div class="form-group">
                            <label class="control-label" for="email">Meal Type</label>
                            <select name="recipe_mealtype" id="recipe_mealtype" class="form-control">
                                <option value="0">Select Meal Type</option>
                                <%
                                    Criteria c1 = s.createCriteria(FoodCategory.class);
                                    List<FoodCategory> lfc = c1.list();
                                    for (FoodCategory fc : lfc) {
                                %>
                                <option value="<%=fc.getIdfoodCategory()%>"><%=fc.getCategoryName()%></option>
                                <%}%>
                            </select>
                        </div>

                        <!--Select cuisine style-->
                        <div class="form-group">
                            <label class="control-label" for="email">Cuisine Style</label>
                            <select name="recipe_cusine" id="recipe_cuisine" class="form-control">
                                <option value="0">Select Cuisine Style</option>
                                <%
                                    Criteria c2 = s.createCriteria(CuisineCategory.class);
                                    List<CuisineCategory> lcs = c2.list();
                                    for (CuisineCategory cc : lcs) {
                                %>
                                <option value="<%=cc.getIdcuisineCategory()%>"><%=cc.getCuisineName()%></option>
                                <%}%>
                            </select>
                        </div>

                        <!--Select health category-->
                        <div class="form-group">
                            <label class="control-label" for="email">Health Category</label>
                            <select name="recipe_healthcat" id="recipe_healthcat" class="form-control">
                                <option value="0">Select Health Category</option>
                                <%
                                    Criteria c3 = s.createCriteria(HealthCategory.class);
                                    List<HealthCategory> lhc = c3.list();
                                    for (HealthCategory hc : lhc) {
                                %>
                                <option value="<%=hc.getIdhealthCategory()%>"><%=hc.getCategoryName()%></option>
                                <%}%>
                            </select>
                        </div>

                        <!--                        Select ingredients to exclude
                                                <div class="form-group">
                                                    <label class="control-label" for="email">Exclude</label>
                                                    <select name="recipe_exclude" id="recipe_exclude" class="form-control">
                                                        <option value="0">Select Ingredient to Exclude</option>
                        <%
                            Criteria c4 = s.createCriteria(Ingredient.class);
                            List<Ingredient> li = c4.list();
                            for (Ingredient ing : li) {
                        %>
                        <option value="<%=ing.getIdingredient()%>"><%=ing.getName()%></option>
                        <%}%>
                    </select>
                </div>-->

                        <button class="btn btn-default btn-block" type="submit">
                            <span class="glyphicon glyphicon-search"></span> Search Kitchen Hunt 
                        </button>

                        <hr><br><br>

                    </form>

                </div>
                <!--End of recipe search sidebar-->

                <!--Beginning of search results display-->
                <div class="col-sm-9">

                    <div class="row">


                        <%
                            if (request.getSession().getAttribute("recipeList") != null) {
                                ArrayList recipeList = (ArrayList) request.getSession().getAttribute("recipeList");

                                if (recipeList.size() == 0) {

                        %>
                            
                        <div class="container-fluid" align="center">
                            <img src="images/no results found.jpg" class="img-responsive">
                        </div>
                        
                        <%
                                    
                    } else {
                        for (Object object : recipeList) {
                            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(object.toString()));
                        %>

                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">

                                <%
                                    Set image_set = r.getImages();
                                    Iterator iter = image_set.iterator();
                                    Image im = (Image) iter.next();
                                %>

                                <!--Image-->
                                <%if (im != null) {%>
                                <img src="<%=im.getPath()%>" alt="<%=r.getName()%>" class="img-responsive">
                                <%}%>
                                <div class="caption">

                                    <!--Recipe name-->
                                    <h3><%=r.getName()%></h3>

                                    <!--Posted by-->
                                    <p>By: <%=r.getUser().getFname()%></p>

                                    <!--Meal type-->
                                    <p>Meal Type: <%=r.getFoodCategory().getCategoryName()%></p>

                                    <!--Cuisine Style-->
                                    <p>Cuisine Style: <%=r.getCuisineCategory().getCuisineName()%></p>

                                    <!--View Recipe button-->
                                    <p><a href="view_recipe.jsp?rid=<%=r.getIdrecipe()%>" class="btn btn-default btn-block" role="button">View Recipe</a> 

                                </div>
                            </div>
                        </div>
                        <%}
                            }
                        } else {%>

                        <div class="container-fluid" align="center">
                            <img src="images/Ingredients.png" height="150px" width="=auto">
                            <h1><small>Just add your ingredients and select your preferences.</small></h1>
                            <hr>
                            <br>
                            <img src="images/Recipe.png" height="150px" width="=auto">
                            <h1><small>Kitchen Hunt instantly finds matching recipes from our recipe database.</small></h1>
                            <hr>
                            <br>
                            <img src="images/MyKitchen.png" height="150px" width="=auto">
                            <h1><small>Create a My Kitchen account to save your favourite recipes.</small></h1>

                        </div>

                        <%}%>
                    </div>
                </div>
                <!--End of search results display-->


                <br>
                <br>
                <br>
                <br>
            </div>
        </div>
    </div>

    <!--Beginning of footer-->
    <footer class="footer-distributed">

        <div class="footer-right">

                <a href="https://www.facebook.com/kitchenhuntr/" target="_blank"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-github"></i></a>

            </div>

            <div class="footer-left">

                <p class="footer-links">
                    <a href="index.jsp">Home</a>
                    ·
                    <a href="recipe_search.jsp">Recipe Search</a>
                    ·
                    <a href="help.jsp">Help</a>
                    ·
                    <a href="about.jsp">About</a>
                    ·
                    <a href="contact_us.jsp">Contact</a>
                </p>

            <p>Kitchen Hunt &copy; 2016</p>
        </div>

    </footer>
    <!--End of footer-->



</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/sidebar.js"></script>



</html>

