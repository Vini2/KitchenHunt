<%-- 
    Document   : admin_signin
    Created on : May 2, 2016, 1:19:06 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Kitchen Hunt - Admin Sign In</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">

        <link rel="stylesheet" href="css/footer-distributed.css">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

        <script src="js/adminjavascript.js"></script>

    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        <!--<img alt="Brand" src="images/KitchenHunt.png" height="32" width="auto">-->
                        <a class="navbar-brand" href="index.jsp">Kitchen Hunt</a>
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
                            <ul id="g-account-menu" class="dropdown-menu" role="menu">
                                <li><a href="#">My Profile</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
                    </ul>
                </div>
        </nav>
        <!-- /container -->
    </div>

    <div class="container">
        <div class="page-header" align="center">
            <h1><small>Administrator Sign In</small></h1>
        </div>
        <div align="center">
            <img src="images/admin/signin.png" height="200px" width="auto">
        </div>
    </div>

    <div style="width:25%; margin:0 auto;">
        <form role="form" action="" onsubmit="signIn(this); return false;" method="POST" id="login_form">
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="email" class="form-control" name="signin_email" required>
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" name="signin_password" required>
            </div>
            <div><br></div>
            <div align="right">
                <input type="submit" id="signin" name="signin" value="Sign In" class="btn btn-success btn-block"/>
            </div>
        </form>
    </div>

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

</body>
</html>
