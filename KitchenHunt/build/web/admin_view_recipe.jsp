<%-- 
    Document   : admin_view_recipe
    Created on : Jun 14, 2016, 11:21:49 PM
    Author     : User
--%>

<%@page import="HibFiles.Image"%>
<%@page import="HibFiles.RecipeHasIngredient"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="HibFiles.Recipe"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="HibFiles.User"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
<%@page import="HibFiles.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Kitchen Hunt - Administrator Dashboard</title>

        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
            Session s = PoolManager.getSessionFactory().openSession();

            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("admin_signin.jsp");
            } else if (!ul.getUser().getUserType().getTypeName().equals("Admin")) {
                response.sendRedirect("index.jsp");
            } else {
                User u = (User) s.load(User.class, ul.getUser().getIduser());
                Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(request.getParameter("rid")));

        %>

        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Other scripts -->
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/footer-distributed.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/myjavascript.js"></script>

    </head>
    <body>

        <!--Beginning of navigation bar-->
        <!-- header -->
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
                <div class="navbar-collapse collapse">

                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="AdminSignOut"><i class="glyphicon glyphicon-lock"></i> Sign Out</a></li>
                    </ul>
                </div>
            </div>
            <!-- /container -->
        </nav>
        <!-- /Header -->
        <!--End of navigation bar-->

        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                    <!-- Left column -->
                    <ul class="nav nav-stacked">
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu"><strong>Recipes</strong></a>
                            <ul class="nav nav-stacked collapse in" id="userMenu">
                                <li><a href="admin_publish_recipe.jsp">Publish Recipes <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                                <li><a href="admin_manage_category.jsp">Manage Categories</a></li>

                            </ul>
                        </li>
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2"><strong>Users</strong></a>

                            <ul class="nav nav-stacked collapse" id="menu2">
                                <li><a href="admin_manage_users.jsp">Manage Users</a></li>
                                <li><a href="admin_manage_admins.jsp">Manage Administrators</a></li>
                            </ul>
                        </li>

                    </ul>

                    <hr>


                </div>
                <!-- /col-3 -->
                <div class="col-sm-9">

                    <a href="admin_home.jsp"><strong><i class="glyphicon glyphicon-dashboard"></i> Administrator Dashboard</strong></a>
                    <hr>

                    <div class="row">

                        <div class="col-md-12">

                            <%                                if (request.getParameter("msg") != null) {
                                    if (request.getParameter("msg").equals("success")) {
                            %>
                            <div class="alert alert-success fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Success!</strong> Recipe was published successfully.
                            </div>

                            <%  } else if (request.getParameter("msg").equals("error")) {%>
                            <div class="alert alert-danger fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Error!</strong> An error occurred while publishing.
                            </div>
                            <%}
                                }%>

                            <!--Beginning of recipe details-->
                            <div style="width:100%; margin:0 auto;" class="well">

                                <div class="row">

                                    <div class="col-xs-6 col-md-4">
                                        <div class="row">

                                            <div class="col-xs-12 col-md-12"><h2><%=r.getName()%></h2></div>

                                        </div>

                                        <%
                                            if (request.getSession().getAttribute("user") != null) {
                                        %>
                                        <div id="rateYo1"></div>
                                        <%} else {%>
                                        <div id="rateYo2"></div>
                                        <%}%>

                                        <h3><%=r.getRatedCount()%> reviewed</h3>
                                        <br>
                                        <h4>Recipe by: <%=r.getUser().getFname()%></h4>
                                        <br>

                                        <h4>Skill Level: <%=r.getSkillLevel()%></h4>

                                        <h4>Preparation Time: <%=r.getPreparingTime()%></h4>

                                        <h4>Serves: <%=r.getServingQuantity()%></h4>

                                        <br>

                                        <%if (r.getStatus().equals("New")) {%>
                                        <h4>
                                            <a href="PublishRecipe?rid=<%=r.getIdrecipe()%>" class="btn btn-primary" role="button">Publish Recipe</a>
                                            <a href="RemoveRecipe?rid=<%=r.getIdrecipe()%>" class="btn btn-danger" role="button">Remove Recipe</a>
                                        </h4>                    
                                        <%}%>

                                    </div>

                                    <div class="col-xs-12 col-md-8" align="right">

                                        <%
                                            Set image_set = r.getImages();
                                            Iterator iter = image_set.iterator();
                                            Image im = (Image) iter.next();
                                        %>
                                        <img src="<%=im.getPath()%>" alt="<%=r.getName()%>" class="img-responsive" width="600px" height="auto">
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-xs-12"><h3>Ingredients for <%=r.getName()%></h3></div>
                                </div>

                                <%
                                    Set<RecipeHasIngredient> ss = r.getRecipeHasIngredients();
                                    int count = 0;
                                    for (RecipeHasIngredient i : ss) {
                                        ++count;

                                        Double d = i.getQuantity();
                                        int q = d.intValue();

                                        if (count % 3 == 1) {
                                %>
                                <div class="row">
                                    <div class="col-xs-6 col-md-4"><%=q%> <%=i.getUnit().getName()%>  <%=i.getIngredient().getName()%></div>
                                    <%} else if (count % 3 == 2) {%>
                                    <div class="col-xs-6 col-md-4"><%=q%> <%=i.getUnit().getName()%>  <%=i.getIngredient().getName()%></div>
                                    <%} else if (count % 3 == 0) {%>
                                    <div class="col-xs-6 col-md-4"><%=q%> <%=i.getUnit().getName()%>  <%=i.getIngredient().getName()%></div>
                                </div> 

                                <%}
                                    }%>
                            </div>
                            <!--<div class="row">
                            <div class="col-xs-6 col-md-4">2 star anise</div>
                            <div class="col-xs-6 col-md-4">4 baking potatoes</div>
                            <div class="col-xs-6 col-md-4">200ml/7fl oz double cream</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-md-4">1 lemon, juice only</div>
                            <div class="col-xs-6 col-md-4">3 tbsp chives, finely sliced</div>
                            <div class="col-xs-6 col-md-4">sea salt and freshly ground black pepper</div>
                        </div>-->
                            <div class="row">
                                <div class="col-xs-12"><br><h3>Directions to prepare <%=r.getName()%></h3></div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <%=r.getDirections()%>
                                    <br><br>
                                </div>

                            </div>

                        </div>
                        <!-- End of recipe details-->

                    </div>

                </div>


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

    <%}%>

    <!--End of footer-->
    <!-- /.modal -->
    <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
