package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import HibFiles.Ingredient;
import HibFiles.HealthCategory;
import HibFiles.CuisineCategory;
import HibFiles.FoodCategory;
import HibFiles.Image;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import HibFiles.Recipe;
import org.hibernate.Session;
import HibFiles.PoolManager;
import org.hibernate.Criteria;
import HibFiles.UserLogin;

public final class recipe_005fsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("        <title>Kitchen Hunt - Search</title>\n");
      out.write("\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            Session s = PoolManager.getSessionFactory().openSession();
        
      out.write("\n");
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Other scripts -->\n");
      out.write("        <link href=\"css/sidebar.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"font-awesome-4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/footer-distributed.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.css\" />\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/myjavascript.js\"></script>\n");
      out.write("        <script src=\"js/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.js\"></script>\n");
      out.write("\n");
      out.write("        <!--Script for auto-complete search-->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("\n");
      out.write("            ");

                Criteria c11 = s.createCriteria(Recipe.class);
                c11.addOrder(Order.asc("idrecipe"));
                List<Recipe> lr1 = c11.list();
            
      out.write("\n");
      out.write("                var availableTags = [\n");
      out.write("            ");

                for (Recipe r : lr1) {
            
      out.write("\n");
      out.write("                    \"");
      out.print(r.getName());
      out.write("\",\n");
      out.write("            ");
}
      out.write("\n");
      out.write("                ];\n");
      out.write("                $(\"#tags\").autocomplete({\n");
      out.write("                    source: availableTags\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--Beginning of navigation bar-->\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <!--<img alt=\"Brand\" src=\"images/KitchenHunt.png\" height=\"32\" width=\"auto\">-->\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                        <img alt=\"Kitchen Hunt\" src=\"images/KitchenHunt.png\" height=\"28\" width=\"auto\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"recipe_search.jsp\">Recipe Search</a></li>\n");
      out.write("                        <li><a href=\"help.jsp\">Help</a></li>\n");
      out.write("                        <li><a id=\"idabout\" href=\"about.jsp\">About</a></li>\n");
      out.write("                        <li><a id=\"idcontact\" href=\"contact_us.jsp\">Contact Us</a></li>\n");
      out.write("\n");
      out.write("                        ");

                            if (request.getSession().getAttribute("user") != null) {
                                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                        
      out.write("\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> ");
      out.print(ul.getUser().getFname());
      out.write("<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"user_dashboard.jsp\">My Kitchen Dashboard</a></li>\n");
      out.write("                                <li><a href=\"SignOut\">Sign Out</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> My Kitchen<span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#signUpModal\">Sign Up</a></li>\n");
      out.write("                                <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#signInModal\">Sign In</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div><!-- /.navbar-collapse -->\n");
      out.write("            </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("        <!--End of navigation bar-->\n");
      out.write("\n");
      out.write("        <!-- Sign Up Modal -->\n");
      out.write("        <div id=\"signUpModal\" class=\"modal fade\" role=\"dialog\" align=\"center\">\n");
      out.write("            <div class=\"modal-dialog\" >\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content modal-sm\"  >\n");
      out.write("                    <div class=\"modal-header\" style=\"text-align: center\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h3 class=\"modal-title\">Sign Up</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\" align=\"left\">\n");
      out.write("                        <form role=\"form\" action=\"\" onsubmit=\"signUp(this); return false;\" method=\"POST\" id=\"testform\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"name\">Name:</label>\n");
      out.write("                                <input type=\"name\" class=\"form-control\" name=\"signup_name\" id=\"idname\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"name\">Mobile:</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"signup_mobile\" id=\"idmobile\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email address:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"signup_email\" id=\"idemail\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signup_password\" id=\"idpassword\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Confirm password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signup_confirmpassword\" id=\"idconfirmpassword\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div align=\"right\">\n");
      out.write("                                <input type=\"submit\" value=\"Sign Up\" class=\"btn btn-success btn-block\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Sign In Modal -->\n");
      out.write("        <div id=\"signInModal\" class=\"modal fade\" role=\"dialog\" align=\"center\">\n");
      out.write("            <div class=\"modal-dialog\" >\n");
      out.write("\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content modal-sm\"  >\n");
      out.write("                    <div class=\"modal-header\" style=\"text-align: center\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h3 class=\"modal-title\">Sign In</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\" align=\"left\">\n");
      out.write("                        <form role=\"form\" action=\"\" onsubmit=\"signIn(this); return false;\" method=\"POST\" id=\"signin_form\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email address:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"signin_email\" value=\"");
      out.print(email);
      out.write("\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signin_password\" value=\"");
      out.print(pass);
      out.write("\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label><input type=\"checkbox\" id=\"rememberMe\"> Remember me</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div align=\"right\">\n");
      out.write("                                <input type=\"submit\" value=\"Sign In\" class=\"btn btn-success btn-block\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Beginning of recipe search sidebar-->\n");
      out.write("        <div class=\"container-fluid\" style=\"width:98%; margin:0 auto;\">\n");
      out.write("            <div class=\"row content\">\n");
      out.write("                <div class=\"col-sm-3 sidenav\">\n");
      out.write("\n");
      out.write("                    <!--<div class=\"input-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search Kitchen Hunt...\">\n");
      out.write("                        <span class=\"input-group-btn\">\n");
      out.write("                            <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-search\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </span>\n");
      out.write("                    </div>-->\n");
      out.write("\n");
      out.write("                    <!--Auto-complete search input-->\n");
      out.write("\n");
      out.write("                    <form action=\"GeneralSearch\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" name=\"search\" id=\"tags\" class=\"form-control\" placeholder=\"Search Kitchen Hunt...\" required/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <button class=\"btn btn-default btn-block\" type=\"submit\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-search\"></span> Search Kitchen Hunt \n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <form role=\"form\" action=\"RecipeSearch\" method=\"POST\" id=\"testform\">\n");
      out.write("\n");
      out.write("                        <!--Enter ingredient to include-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">Ingredient to include</label>\n");
      out.write("                            <input type=\"text\" name=\"recipe_inc_ing\" id=\"recipe_inc_ing\" class=\"form-control\" placeholder=\"\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--Enter ingredient to exclude-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">Ingredient to exclude</label>\n");
      out.write("                            <input type=\"text\" name=\"recipe_ex_ing\" id=\"recipe_ex_ing\" class=\"form-control\" placeholder=\"\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--Select meal type-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">Meal Type</label>\n");
      out.write("                            <select name=\"recipe_mealtype\" id=\"recipe_mealtype\" class=\"form-control\">\n");
      out.write("                                <option value=\"0\">Select Meal Type</option>\n");
      out.write("                                ");

                                    Criteria c1 = s.createCriteria(FoodCategory.class);
                                    List<FoodCategory> lfc = c1.list();
                                    for (FoodCategory fc : lfc) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(fc.getIdfoodCategory());
      out.write('"');
      out.write('>');
      out.print(fc.getCategoryName());
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--Select cuisine style-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">Cuisine Style</label>\n");
      out.write("                            <select name=\"recipe_cusine\" id=\"recipe_cuisine\" class=\"form-control\">\n");
      out.write("                                <option value=\"0\">Select Cuisine Style</option>\n");
      out.write("                                ");

                                    Criteria c2 = s.createCriteria(CuisineCategory.class);
                                    List<CuisineCategory> lcs = c2.list();
                                    for (CuisineCategory cc : lcs) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(cc.getIdcuisineCategory());
      out.write('"');
      out.write('>');
      out.print(cc.getCuisineName());
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--Select health category-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"email\">Health Category</label>\n");
      out.write("                            <select name=\"recipe_healthcat\" id=\"recipe_healthcat\" class=\"form-control\">\n");
      out.write("                                <option value=\"0\">Select Health Category</option>\n");
      out.write("                                ");

                                    Criteria c3 = s.createCriteria(HealthCategory.class);
                                    List<HealthCategory> lhc = c3.list();
                                    for (HealthCategory hc : lhc) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(hc.getIdhealthCategory());
      out.write('"');
      out.write('>');
      out.print(hc.getCategoryName());
      out.write("</option>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--                        Select ingredients to exclude\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label class=\"control-label\" for=\"email\">Exclude</label>\n");
      out.write("                                                    <select name=\"recipe_exclude\" id=\"recipe_exclude\" class=\"form-control\">\n");
      out.write("                                                        <option value=\"0\">Select Ingredient to Exclude</option>\n");
      out.write("                        ");

                            Criteria c4 = s.createCriteria(Ingredient.class);
                            List<Ingredient> li = c4.list();
                            for (Ingredient ing : li) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(ing.getIdingredient());
      out.write('"');
      out.write('>');
      out.print(ing.getName());
      out.write("</option>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>-->\n");
      out.write("\n");
      out.write("                        <button class=\"btn btn-default btn-block\" type=\"submit\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-search\"></span> Search Kitchen Hunt \n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <hr><br><br>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!--End of recipe search sidebar-->\n");
      out.write("\n");
      out.write("                <!--Beginning of search results display-->\n");
      out.write("                <div class=\"col-sm-9\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (request.getSession().getAttribute("recipeList") != null) {
                                ArrayList recipeList = (ArrayList) request.getSession().getAttribute("recipeList");

                                if (recipeList.size() == 0) {

                        
      out.write("\n");
      out.write("                            \n");
      out.write("                        <div class=\"container-fluid\" align=\"center\">\n");
      out.write("                            <img src=\"images/no results found.jpg\" class=\"img-responsive\">\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        ");

                                    
                    } else {
                        for (Object object : recipeList) {
                            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(object.toString()));
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-6 col-md-4\">\n");
      out.write("                            <div class=\"thumbnail\">\n");
      out.write("\n");
      out.write("                                ");

                                    Set image_set = r.getImages();
                                    Iterator iter = image_set.iterator();
                                    Image im = (Image) iter.next();
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <!--Image-->\n");
      out.write("                                ");
if (im != null) {
      out.write("\n");
      out.write("                                <img src=\"");
      out.print(im.getPath());
      out.write("\" alt=\"");
      out.print(r.getName());
      out.write("\" class=\"img-responsive\">\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                <div class=\"caption\">\n");
      out.write("\n");
      out.write("                                    <!--Recipe name-->\n");
      out.write("                                    <h3>");
      out.print(r.getName());
      out.write("</h3>\n");
      out.write("\n");
      out.write("                                    <!--Posted by-->\n");
      out.write("                                    <p>By: ");
      out.print(r.getUser().getFname());
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    <!--Meal type-->\n");
      out.write("                                    <p>Meal Type: ");
      out.print(r.getFoodCategory().getCategoryName());
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    <!--Cuisine Style-->\n");
      out.write("                                    <p>Cuisine Style: ");
      out.print(r.getCuisineCategory().getCuisineName());
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    <!--View Recipe button-->\n");
      out.write("                                    <p><a href=\"view_recipe.jsp?rid=");
      out.print(r.getIdrecipe());
      out.write("\" class=\"btn btn-default btn-block\" role=\"button\">View Recipe</a> \n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
}
                            }
                        } else {
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"container-fluid\" align=\"center\">\n");
      out.write("                            <img src=\"images/Ingredients.png\" height=\"150px\" width=\"=auto\">\n");
      out.write("                            <h1><small>Just add your ingredients and select your preferences.</small></h1>\n");
      out.write("                            <hr>\n");
      out.write("                            <br>\n");
      out.write("                            <img src=\"images/Recipe.png\" height=\"150px\" width=\"=auto\">\n");
      out.write("                            <h1><small>Kitchen Hunt instantly finds matching recipes from our recipe database.</small></h1>\n");
      out.write("                            <hr>\n");
      out.write("                            <br>\n");
      out.write("                            <img src=\"images/MyKitchen.png\" height=\"150px\" width=\"=auto\">\n");
      out.write("                            <h1><small>Create a My Kitchen account to save your favourite recipes.</small></h1>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--End of search results display-->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--Beginning of footer-->\n");
      out.write("    <footer class=\"footer-distributed\">\n");
      out.write("\n");
      out.write("        <div class=\"footer-right\">\n");
      out.write("\n");
      out.write("                <a href=\"https://www.facebook.com/kitchenhuntr/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-github\"></i></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-left\">\n");
      out.write("\n");
      out.write("                <p class=\"footer-links\">\n");
      out.write("                    <a href=\"index.jsp\">Home</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"recipe_search.jsp\">Recipe Search</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"help.jsp\">Help</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"about.jsp\">About</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"contact_us.jsp\">Contact</a>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("            <p>Kitchen Hunt &copy; 2016</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </footer>\n");
      out.write("    <!--End of footer-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"js/sidebar.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
