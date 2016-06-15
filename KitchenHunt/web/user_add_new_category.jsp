<%-- 
    Document   : user_add_new_category
    Created on : Jun 12, 2016, 4:24:12 PM
    Author     : User
--%>

<%@page import="HibFiles.HealthCategory"%>
<%@page import="HibFiles.CuisineCategory"%>
<%@page import="HibFiles.FoodCategory"%>
<%@page import="HibFiles.Notification"%>
<%@page import="HibFiles.Image"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="HibFiles.Recipe"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="HibFiles.User"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
<%@page import="HibFiles.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <title>Kitchen Hunt - Add New Category</title>

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
                Session s1 = PoolManager.getSessionFactory().openSession();

                User u = (User) s1.load(User.class, ul.getUser().getIduser());
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
        <script src="js/myjavascript.js"></script>


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
                    <a class="navbar-brand" href="index.jsp"><img alt="Kitchen Hunt" src="images/KitchenHunt.png" height="28" width="auto"></a>
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
                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getFname()%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="user_dashboard.jsp">My Kitchen Dashboard</a></li>
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
                                <li><a href="user_recipes.jsp">My Recipes</a></li>
                                <li><a href="user_post_new_recipe.jsp">Post New Recipe</a></li>
                                <li><a href="user_ingredients.jsp">My Ingredients</a></li>
                                <li><a href="user_add_new_category.jsp">Add New Category <span class="glyphicon glyphicon-chevron-right"></span></a></li>

                                <%

                                    Criteria c = s1.createCriteria(Notification.class);
                                    c.add(Restrictions.eq("user", u));
                                    c.add(Restrictions.eq("status", "Unread"));
                                    List<Notification> n_list = c.list();

                                    int len = n_list.size();
                                %>

                                <li><a href="user_notifications.jsp">Notifications 
                                        <%if (len != 0) {%>
                                        <span class="badge badge-info"><%=len%></span> 
                                        <%}%>
                                    </a>
                                </li>
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
                        <strong>Success!</strong> Category added successfully.
                    </div>

                    <%} else if (request.getParameter("msg").equals("exists")) {%>
                    <div class="alert alert-warning fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Duplicate!</strong> Category already exists.
                    </div>

                    <%  } else if (request.getParameter("msg").equals("error")) {%>
                    <div class="alert alert-danger fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> An error occurred while adding the category.
                    </div>
                    <%}
            }%>


                    <div class="row">
                        <div align="center"><h1><small id="">Meal Type</small></h1></div>
                        <br>
                        <div class="col-sm-6">
                            <ul class="list-group">
                                <%
                                    Criteria c1 = s1.createCriteria(FoodCategory.class);
                                    List<FoodCategory> lfc = c1.list();
                                    for (FoodCategory fc : lfc) {
                                %>
                                <li class="list-group-item"><%=fc.getCategoryName()%></li>
                                    <%}%>
                            </ul>
                        </div>

                        <div class="col-sm-6">
                            <form action="AddNewMealType" method="POST">
                                <div class="form-group">
                                    <input type="text" name="meal" id="idmeal" class="form-control" placeholder="Enter meal type" required/>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-default btn-block" type="submit">
                                        <span class="glyphicon glyphicon-plus"></span> Add New Meal Type
                                    </button>
                                </div>
                            </form>
                        </div>

                    </div>
                    <hr>

                    <div class="row">
                        <div align="center"><h1><small id="">Cuisine Style </small></h1></div>
                        <br>
                        <div class="col-sm-6">
                            <ul class="list-group">
                                <%
                                    Criteria c2 = s1.createCriteria(CuisineCategory.class);
                                    List<CuisineCategory> lcs = c2.list();
                                    for (CuisineCategory cc : lcs) {
                                %>
                                <li class="list-group-item"><%=cc.getCuisineName()%></li>
                                    <%}%>
                            </ul>
                        </div>

                        <div class="col-sm-6">
                            <form action="AddNewCuisineStyle" method="POST">
                                <div class="form-group">
                                    <input type="text" name="cuisine" id="idcuisine" class="form-control" placeholder="Enter cuisine style" required/>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-default btn-block" type="submit">
                                        <span class="glyphicon glyphicon-plus"></span> Add New Cuisine Style
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div align="center"><h1><small id="">Health Category</small></h1></div>
                        <br>
                        <div class="col-sm-6">
                            <ul class="list-group">
                                <%
                                    Criteria c3 = s1.createCriteria(HealthCategory.class);
                                    List<HealthCategory> lhc = c3.list();
                                    for (HealthCategory hc : lhc) {
                                %>
                                <li class="list-group-item"><%=hc.getCategoryName()%></li>
                                    <%}%>
                            </ul>
                        </div>

                        <div class="col-sm-6">
                            <form action="AddNewHealthCat" method="POST">
                                <div class="form-group">
                                    <input type="text" name="health" id="idhealth" class="form-control" placeholder="Enter health category" required/>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-default btn-block" type="submit">
                                        <span class="glyphicon glyphicon-plus"></span> Add New Health Category
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr>


                </div>
                <!--/col-span-9-->
            </div>
        </div>
        <!-- /Main -->




        <!--Beginning of footer-->
        <footer class="footer-distributed">

            <div class="footer-right">

                <a href="https://www.facebook.com/kitchenhuntr/" target="_blank"><i class="fa fa-facebook"></i></a>
                <a href="https://twitter.com/kitchenhuntr" target="_blank"><i class="fa fa-twitter"></i></a>
                <a href="https://github.com/Vini2/KitchenHunt" target="_blank"><i class="fa fa-github"></i></a>

            </div>

            <div class="footer-left">

                <p class="footer-links">
                    <a href="index.jsp">Home</a>
                    ·
                    <a href="recipe_search.jsp">Recipes</a>
                    ·
                    <a href="about.jsp">About</a>
                    ·
                    <a href="contact_us.jsp">Contact</a>
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




