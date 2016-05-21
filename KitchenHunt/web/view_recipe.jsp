<%-- 
    Document   : view_recipe
    Created on : Apr 8, 2016, 10:08:35 AM
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="HibFiles.Comment"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Iterator"%>
<%@page import="HibFiles.Image"%>
<%@page import="HibFiles.RecipeHasIngredient"%>
<%@page import="java.util.Set"%>
<%@page import="HibFiles.Recipe"%>
<%@page import="org.hibernate.Session"%>
<%@page import="HibFiles.PoolManager"%>
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
        <title>Kitchen Hunt - View Recipe</title>

        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            request.getSession().removeAttribute("recipeList");

            Session s = PoolManager.getSessionFactory().openSession();
            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(request.getParameter("rid")));

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
        <link rel="stylesheet" href="css/jquery.rateyo.min.css"/>

        <script type="text/javascript" src="js/myjavascript.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.rateyo.min.js"></script>

        <script>

            $(function () {

                var rating = <%=r.getOverallRating()%>;

                $("#rateYo2").rateYo({
                    rating: rating,
                    readOnly: true
                });

                $("#rateYo1").rateYo({
                    rating: rating,
                    onInit: function () {
                        console.log("On Init");
                    },
                    onSet: function (rating1, rateYoInstance) {

                        alert("Rating is set to: " + rating1);
                        postRating(rating1);
                    }
                }).on("rateyo.set", function () {
                    console.log("rateyo.set");
                })
                        .on("rateyo.change", function () {
                            console.log("rateyo.change");
                        });

            });


            function postRating(rating2) {

                var a;
                var rid = <%=request.getParameter("rid")%>;

                if (window.XMLHttpRequest) {
                    a = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    a = new ActiveXObject("Microsoft.XMLHTTP");
                } else {
                    alert("Browser does not support AJAX");
                }

                if (a != null) {
                    a.onreadystatechange = function () {
                        if (a.readyState === 4) {
                            var res = a.responseText;

                            if (res == 'Error') {
                                alert("You have already rated this recipe...");
                                reloadPage();
                            } else if (res == 'success') {
                                alert("Rated successfully...");
                                reloadPage();
                            } else {
                                //alert("Incorrect email address or password.");
                            }
                        }
                    }

                    a.open("POST", "PostRating", true);
                    a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    a.send("rid=" + rid + "&rating=" + rating2);

                }
            }


        </script>



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

                        <%                            if (request.getSession().getAttribute("user") != null) {
                                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
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
                        <form role="form" action="" onsubmit="signUp(this);
                                return false;" method="POST" id="testform">
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
                        <form role="form" action="" onsubmit="signIn(this);
                                return false;" method="POST" id="signin_form">
                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <input type="email" class="form-control" id="signin_email" name="signin_email" value="<%=email%>" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="signin_password" name="signin_password" value="<%=pass%>" required>
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


        <%
            if (request.getParameter("msg") != null) {
                if (request.getParameter("msg").equals("success")) {
        %>
        <div class="alert alert-success fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Success!</strong> Recipe added to My Kitchen successfully.
        </div>

        <%} else if (request.getParameter("msg").equals("exists")) {%>
        <div class="alert alert-warning fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Duplicate!</strong> Recipe already exists in My Kitchen.
        </div>

        <%  } else if (request.getParameter("msg").equals("error")) {%>
        <div class="alert alert-danger fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Error!</strong> An error occurred while adding the recipe to My Kitchen.
        </div>
        <%}
            }%>


        <!--Beginning of recipe details-->
        <div style="width:82%; margin:0 auto;" class="well">

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

                    <%
                        if (request.getSession().getAttribute("user") != null) {
                    %>
                    <h4><a href="AddToMyKitchen?rid=<%=r.getIdrecipe()%>" class="btn btn-success" role="button">Add to My Kitchen</a></h4>                    
                    <%}%>

                </div>

                <div class="col-xs-12 col-md-8" align="right">

                    <%
                        Set image_set = r.getImages();
                        Iterator iter = image_set.iterator();
                        Image im = (Image) iter.next();

//                        byte[] imageblob = im.getImageData();
//                        response.setContentType("image/gif");
//                        OutputStream o = response.getOutputStream();
//
//                    o.write(imageblob);%>
                    <img src="<%=im.getPath()%>" alt="<%=r.getName()%>" width="600px" height="auto">
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

    <br>


    <div style="width:82%; margin:0 auto;" class="panel panel-default">
        <div class="panel-heading">
            <h3>Comments</h3>
        </div>
        <div class="panel-body">
            <%
                if (request.getSession().getAttribute("user") != null) {
            %>
            
            <form role="form" action="" onsubmit="postComment(this); return false;" method="POST" id="postComment_form">
                <div class="row">
                    <div class="form-group col-xs-11">
                        <input type="text" class="form-control" name="comment" id="comment" placeholder="Enter your comment" required>
                    </div>
                    <div class="form-group col-xs-1">
                        <input class="btn btn-success btn-block" type="submit" value="Post">
                    </div>
                </div>
                <input type="text" class="form-control" name="rid" id="rid" value="<%=r.getIdrecipe()%>" style="display: none">
            </form>
            <%}%>

            <hr>

            <%
                Criteria c = s.createCriteria(Comment.class);
                c.add(Restrictions.eq("recipe", r));
                List<Comment> comment_list = c.list();

                for (Comment comment : comment_list) {
            %>
            <div class="row container-fluid">
                <h3><small><%=comment.getUser().getFname()%> commented on <%=comment.getDate()%> at <%=comment.getTime()%></small></h3>
                <%=comment.getCommentDesc()%>
            </div>
            <hr>
            <%

                }

            %>

        </div>
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



</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/sidebar.js"></script>
</html>



