<%-- 
    Document   : view_recipe
    Created on : Apr 8, 2016, 10:08:35 AM
    Author     : User
--%>

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
        <title>Kitchen Hunt - View Recipe</title>
        
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->

        <link href="css/sidebar.css" rel="stylesheet">
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">

        <link rel="stylesheet" href="css/footer-distributed.css">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        
        <script type="text/javascript" src="js/myjavascript.js"></script>

        
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container">
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
                                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                        %>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=ul.getUser().getName()%><span class="caret"></span></a>
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

        <div style="width:82%; margin:0 auto;" class="well">

            <div class="row">

                <div class="col-xs-6 col-md-4">
                    <div class="row">
                        <div class="col-xs-12 col-md-12"><h2>Butter Curls</h2></div>
                    </div>
                    <span class="glyphicon glyphicon-star" aria-hidden="true" style="font-size: 35px;"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true" style="font-size: 35px;"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true" style="font-size: 35px;"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true" style="font-size: 35px;"></span>
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true" style="font-size: 35px;"></span>
                    <br>
                    <h3>186 reviewed</h3>
                    <br>
                    <h4>Recipe by: Vijini Mallawaarachchi</h4>
                    <br>

                    <h4>Preparation Time: 15 minutes</h4>

                    <h4>Serves: 4-6</h4>

                    <br>
                    <h4><a href="#" class="btn btn-success" role="button">Add to My Kitchen</a></h4>

                </div>
                <div class="col-xs-12 col-md-8" align="right">
                    <img src="images/Butter_Curls.jpg" alt="Butter Curls" width="600px" height="auto">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12"><h3>Ingredients</h3></div>
            </div>
            <div class="row">
                <div class="col-xs-6 col-md-4">4 Jacob’s ladder beef ribs</div>
                <div class="col-xs-6 col-md-4">1 onion, chopped</div>
                <div class="col-xs-6 col-md-4">1 tsp fennel seeds</div>
            </div>
            <div class="row">
                <div class="col-xs-6 col-md-4">2 star anise</div>
                <div class="col-xs-6 col-md-4">4 baking potatoes</div>
                <div class="col-xs-6 col-md-4">200ml/7fl oz double cream</div>
            </div>
            <div class="row">
                <div class="col-xs-6 col-md-4">1 lemon, juice only</div>
                <div class="col-xs-6 col-md-4">3 tbsp chives, finely sliced</div>
                <div class="col-xs-6 col-md-4">sea salt and freshly ground black pepper</div>
            </div>
            <div class="row">
                <div class="col-xs-12"><h3>Directions</h3></div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <ol>
                        <li>Place the ribs in a large, wide saucepan. Cover with water and add the onion, garlic, fennel seeds and star anise.</li>
                        <li>Bring to a boil, then reduce the heat and simmer very gently for three hours, or until the meat is tender, skimming any scum off occasionally.</li>
                        <li>Preheat the oven to 200C/400F/Gas 6</li>
                        <li>Rub the baking potatoes with a little oil. Create four small piles of sea salt in a baking tray then place the potatoes on top. Bake for 1-1½ hours, or until tender.</li>
                        <li>Meanwhile, make the bbq sauce. Heat a sauté pan until hot and add the butter, onions and garlic and fry for 4-5 minutes, or until softened.</li>

                    </ol>
                    <br>
                </div>

            </div>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="js/sidebar.js"></script>
</html>



