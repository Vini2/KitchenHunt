<%-- 
    Document   : admin_home
    Created on : May 2, 2016, 1:11:28 PM
    Author     : User
--%>

<%@page import="HibFiles.FoodCategory"%>
<%@page import="HibFiles.Request"%>
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

        %>

        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

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
                                <li><a href="admin_publish_recipe.jsp">Publish Recipes</a></li>
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

                            <div class="panel panel-default">
                                <%                                    Criteria c = s.createCriteria(User.class);
                                    c.add(Restrictions.between("registerDate", new Date(), new Date()));
                                    List<User> u_list = c.list();

                                %>
                                <div class="well">
                                    <h4>New Users Registered Today <span class="badge pull-right"><%=u_list.size()%></span></h4>
                                </div>
                                <div class="panel-body">
                                    <%if (u_list.size() != 0) {%>
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Mobile</th>
                                                <th>Address</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (User us : u_list) {
                                            %>
                                            <tr>
                                                <td><%=us.getFname()%></td>
                                                <td><%=us.getMobile()%></td>
                                                <td><%=us.getAddress()%></td>
                                            </tr>


                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%} else {%>
                                    No new users
                                    <%}%>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <%
                                    Criteria c1 = s.createCriteria(Recipe.class);
                                    c1.add(Restrictions.eq("status", "New"));
                                    List<Recipe> r_list = c1.list();
                                %>
                                <div class="well">
                                    <h4>New Recipes Pending to be Published <span class="badge pull-right"><%=r_list.size()%></span></h4>
                                </div>
                                <div class="panel-body">
                                    <%if (r_list.size() != 0) {%>
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Recipe Name</th>
                                                <th>Posted By</th>
                                                <th>View Recipe</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Recipe recipe : r_list) {
                                            %>
                                            <tr>
                                                <td><%=recipe.getName()%></td>
                                                <td><%=recipe.getUser().getFname()%></td>
                                                <td>
                                                    <a href="admin_view_recipe.jsp?rid=<%=recipe.getIdrecipe()%>" class="btn btn-primary" role="button">View</a> 
                                                </td>
                                            </tr>


                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%} else {%>
                                    No pending recipes
                                    <%}%>
                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="row">
                        <!-- center left-->
                        <div class="col-md-6">


                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Reports on Posted Recipes</h4></div>
                                <div class="panel-body">

                                    <%
                                        Criteria c0 = s.createCriteria(Recipe.class);
                                        List<Recipe> recipe_list = c0.list();

                                        if(recipe_list.size()!=0){
                                        Criteria cfc = s.createCriteria(FoodCategory.class);
                                        List<FoodCategory> fc_list = cfc.list();

                                        for (FoodCategory fc : fc_list) {
                                            Criteria cr1 = s.createCriteria(Recipe.class);
                                            cr1.add(Restrictions.eq("foodCategory", fc));
                                            List<Recipe> cr1_list = cr1.list();

                                            int perc = cr1_list.size() * 100 / recipe_list.size();

                                    %>
                                    <small><%=fc.getCategoryName()%></small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: <%=perc%>%">
                                            <span class="sr-only"><%=perc%>% Complete</span>
                                        </div>
                                    </div>

                                    <%}}else{%>
                                    No recipes found.
                                    <%}%>

                                </div>
                                <!--/panel-body-->
                            </div>
                            <!--/panel-->

                        </div>
                        <!--/col-->



                        <div class="col-md-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Recipe Requests</h4></div>
                                <div class="panel-body">

                                    <%
                                        Criteria cr = s.createCriteria(Request.class);
                                        cr.add(Restrictions.between("date", new Date(), new Date()));
                                        cr.add(Restrictions.eq("status", "Not Responded"));
                                        List<Request> req_list = cr.list();

                                        if (req_list.size() != 0) {
                                    %>
                                    <table class="table table-striped">
                                        <tbody>
                                        <thead>
                                            <tr>
                                                <th>Recipe Name</th>
                                                <th>Requested By</th>
                                            </tr>
                                        </thead>
                                        <%for (Request req : req_list) {%>

                                        <tr>
                                            <td><%=req.getRecipeName()%></td>
                                            <td><%=req.getUser().getFname()%></td>
                                        </tr>


                                        <%}%>
                                        </tbody>
                                    </table>
                                    <%} else {%>
                                    No requests posted
                                    <%}%>

                                </div>
                            </div>



                        </div>
                        <!--/col-span-6-->

                    </div>
                    <!--/row-->

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

        <%}%>

        <!--End of footer-->
        <!-- /.modal -->
        <!-- script references -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
