<%-- 
    Document   : user_dashboard
    Created on : May 1, 2016, 10:51:54 AM
    Author     : User
--%>

<%@page import="HibFiles.User"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
<%@page import="HibFiles.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <title>Kitchen Hunt - My Kitchen</title>

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
                        <li><a id="idabout" href="about.jsp">About</a></li>

                        <%
                            if (request.getSession().getAttribute("user") != null) {
                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getFname()%><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="user_dashboard.jsp">My Kitchen Dashboard</a></li>
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
                        <form role="form" action="" onsubmit="signUp(this); return false;" method="POST" id="signup_form">
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


        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                    <!-- Left column -->
                    <a href="#"><strong><i class="glyphicon glyphicon-wrench"></i> Tools</strong></a>

                    <hr>

                    <ul class="nav nav-stacked">
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">Settings <i class="glyphicon glyphicon-chevron-down"></i></a>
                            <ul class="nav nav-stacked collapse in" id="userMenu">
                                <li class="active"> <a href="#"><i class="glyphicon glyphicon-home"></i> Home</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-envelope"></i> Messages <span class="badge badge-info">4</span></a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Options</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i> Shoutbox</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Staff List</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-flag"></i> Transactions</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-exclamation-sign"></i> Rules</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
                            </ul>
                        </li>
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2"> Reports <i class="glyphicon glyphicon-chevron-right"></i></a>

                            <ul class="nav nav-stacked collapse" id="menu2">
                                <li><a href="#">Information &amp; Stats</a>
                                </li>
                                <li><a href="#">Views</a>
                                </li>
                                <li><a href="#">Requests</a>
                                </li>
                                <li><a href="#">Timetable</a>
                                </li>
                                <li><a href="#">Alerts</a>
                                </li>
                            </ul>
                        </li>
                        
                    </ul>

                    <hr>
                   
                </div>
                <!-- /col-3 -->
                <div class="col-sm-9">

                    <!-- column 2 -->
                    
                    <a href="#"><strong><i class="glyphicon glyphicon-dashboard"></i> My Kitchen Dashboard</strong></a>
                    <hr>

                    <div class="row">

                        <div class="col-md-12">

                            <div class="panel panel-default">
                                <div class="well">
                                    <h4>New Users <span class="badge pull-right">3</span></h4>
                                </div>
                                <div class="panel-body">
                                    <p>This is a dashboard-style layout that uses Bootstrap 3. You can use this template as a starting point to create something more unique.</p>
                                    <p>Visit the Bootstrap Playground at <a href="http://bootply.com">Bootply</a> to tweak this layout or discover more useful code snippets.</p>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="well">
                                    <h4>New Recipes Posted <span class="badge pull-right">5</span></h4>
                                </div>
                                <div class="panel-body">
                                    <p>This is a dashboard-style layout that uses Bootstrap 3. You can use this template as a starting point to create something more unique.</p>
                                    <p>Visit the Bootstrap Playground at <a href="http://bootply.com">Bootply</a> to tweak this layout or discover more useful code snippets.</p>
                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="row">
                        <!-- center left-->
                        <div class="col-md-6">
                            <div class="well">Inbox Messages <span class="badge pull-right">3</span></div>

                            <hr>

                            <div class="btn-group btn-group-justified">
                                <a href="#" class="btn btn-primary col-sm-3">
                                    <i class="glyphicon glyphicon-plus"></i>
                                    <br> Service
                                </a>
                                <a href="#" class="btn btn-primary col-sm-3">
                                    <i class="glyphicon glyphicon-cloud"></i>
                                    <br> Cloud
                                </a>
                                <a href="#" class="btn btn-primary col-sm-3">
                                    <i class="glyphicon glyphicon-cog"></i>
                                    <br> Tools
                                </a>
                                <a href="#" class="btn btn-primary col-sm-3">
                                    <i class="glyphicon glyphicon-question-sign"></i>
                                    <br> Help
                                </a>
                            </div>

                            <hr>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Reports</h4></div>
                                <div class="panel-body">

                                    <small>Success</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%">
                                            <span class="sr-only">72% Complete</span>
                                        </div>
                                    </div>
                                    <small>Info</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                    <small>Warning</small> 
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                    <small>Danger</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </div>
                                <!--/panel-body-->
                            </div>
                            <!--/panel-->

                            <hr>

                            <!--tabs-->
                            <div class="panel">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#profile" data-toggle="tab">Profile</a></li>
                                    <li><a href="#messages" data-toggle="tab">Messages</a></li>
                                    <li><a href="#settings" data-toggle="tab">Settings</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active well" id="profile">
                                        <h4><i class="glyphicon glyphicon-user"></i></h4> Lorem profile dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate.
                                        <p>Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean sit amet felis dolor, in sagittis nisi.</p>
                                    </div>
                                    <div class="tab-pane well" id="messages">
                                        <h4><i class="glyphicon glyphicon-comment"></i></h4> Message ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate.
                                        <p>Quisque mauris augu.</p>
                                    </div>
                                    <div class="tab-pane well" id="settings">
                                        <h4><i class="glyphicon glyphicon-cog"></i></h4> Lorem settings dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate.
                                        <p>Quisque mauris augue, molestie.</p>
                                    </div>
                                </div>

                            </div>
                            <!--/tabs-->

                            <hr>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>New Requests</h4></div>
                                <div class="panel-body">
                                    <div class="list-group">
                                        <a href="#" class="list-group-item active">Hosting virtual mailbox serv..</a>
                                        <a href="#" class="list-group-item">Dedicated server doesn't..</a>
                                        <a href="#" class="list-group-item">RHEL 6 install on new..</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--/col-->
                        <div class="col-md-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Notices</h4></div>
                                <div class="panel-body">
                                    <div class="alert alert-info">
                                        <button type="button" class="close" data-dismiss="alert">×</button>
                                        This is a dismissable alert.. just sayin'.
                                    </div>
                                    <p>This is a dashboard-style layout that uses Bootstrap 3. You can use this template as a starting point to create something more unique.</p>
                                    <p>Visit the Bootstrap Playground at <a href="http://bootply.com">Bootply</a> to tweak this layout or discover more useful code snippets.</p>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Visits</th>
                                            <th>ROI</th>
                                            <th>Source</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>45</td>
                                            <td>2.45%</td>
                                            <td>Direct</td>
                                        </tr>
                                        <tr>
                                            <td>289</td>
                                            <td>56.2%</td>
                                            <td>Referral</td>
                                        </tr>
                                        <tr>
                                            <td>98</td>
                                            <td>25%</td>
                                            <td>Type</td>
                                        </tr>
                                        <tr>
                                            <td>..</td>
                                            <td>..</td>
                                            <td>..</td>
                                        </tr>
                                        <tr>
                                            <td>..</td>
                                            <td>..</td>
                                            <td>..</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <i class="glyphicon glyphicon-wrench pull-right"></i>
                                        <h4>Post Request</h4>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form class="form form-vertical">
                                        <div class="control-group">
                                            <label>Name</label>
                                            <div class="controls">
                                                <input type="text" class="form-control" placeholder="Enter Name">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label>Message</label>
                                            <div class="controls">
                                                <textarea class="form-control"></textarea>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label>Category</label>
                                            <div class="controls">
                                                <select class="form-control">
                                                    <option>options</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label></label>
                                            <div class="controls">
                                                <button type="submit" class="btn btn-primary">
                                                    Post
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!--/panel content-->
                            </div>
                            <!--/panel-->

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <h4>Engagement</h4></div>
                                </div>
                                <div class="panel-body">
                                    <div class="col-xs-4 text-center"><img src="http://placehold.it/80/BBBBBB/FFF" class="img-circle img-responsive"></div>
                                    <div class="col-xs-4 text-center"><img src="http://placehold.it/80/EFEFEF/555" class="img-circle img-responsive"></div>
                                    <div class="col-xs-4 text-center"><img src="http://placehold.it/80/EEEEEE/222" class="img-circle img-responsive"></div>
                                </div>
                            </div>
                            <!--/panel-->

                        </div>
                        <!--/col-span-6-->

                    </div>
                    <!--/row-->

                    <hr>

                    <a href="#"><strong><i class="glyphicon glyphicon-comment"></i> Discussions</strong></a>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(3 mins ago)</small> The 3rd page reports don't contain any links. Does anyone know why..</a></li>
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(1 hour ago)</small> Hi all, I've just post a report that show the relationship betwe..</a></li>
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart"></i> <small>(2 hrs ago)</small> Paul. That document you posted yesterday doesn't seem to contain the over..</a></li>
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart-empty"></i> <small>(4 hrs ago)</small> The map service on c243 is down today. I will be fixing the..</a></li>
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart"></i> <small>(yesterday)</small> I posted a new document that shows how to install the services layer..</a></li>
                                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(yesterday)</small> ..</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--/col-span-9-->
            </div>
        </div>
        <!-- /Main -->

        <footer class="text-center">This Bootstrap 3 dashboard layout is compliments of <a href="http://www.bootply.com/85850"><strong>Bootply.com</strong></a></footer>

        <div class="modal" id="addWidgetModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Add Widget</h4>
                    </div>
                    <div class="modal-body">
                        <p>Add a widget stuff here..</p>
                    </div>
                    <div class="modal-footer">
                        <a href="#" data-dismiss="modal" class="btn">Close</a>
                        <a href="#" class="btn btn-primary">Save changes</a>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dalog -->
        </div>


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

