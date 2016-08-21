package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HibFiles.MyIngredient;
import HibFiles.Ingredient;
import HibFiles.Notification;
import HibFiles.Image;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import HibFiles.Recipe;
import org.hibernate.Criteria;
import HibFiles.User;
import org.hibernate.Session;
import HibFiles.PoolManager;
import HibFiles.UserLogin;

public final class user_005frequest_005frecipe_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("        <title>Kitchen Hunt - My Ingredients</title>\n");
      out.write("\n");
      out.write("        ");

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
      out.write("        <script src=\"js/myjavascript.js\"></script>\n");
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
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\"><img alt=\"Kitchen Hunt\" src=\"images/KitchenHunt.png\" height=\"28\" width=\"auto\"></a>\n");
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
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div><!-- /.navbar-collapse -->\n");
      out.write("            </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("        <!--End of navigation bar-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Main -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <!-- Left column -->\n");
      out.write("                    <strong><i class=\"glyphicon glyphicon-wrench\"></i> Tools</strong>\n");
      out.write("\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav nav-stacked\">\n");
      out.write("                        <li class=\"nav-header\"> <a href=\"#\" data-toggle=\"collapse\" data-target=\"#userMenu\"><strong>Recipes</strong></a>\n");
      out.write("                            <ul class=\"nav nav-stacked collapse in\" id=\"userMenu\">\n");
      out.write("                                <li class=\"active\"><a href=\"user_recipes.jsp\">My Recipes</a></li>\n");
      out.write("                                <li><a href=\"user_post_new_recipe.jsp\">Post New Recipe</a></li>\n");
      out.write("                                <li><a href=\"user_request_recipe.jsp\">Request Recipe <span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>\n");
      out.write("                                <li><a href=\"user_ingredients.jsp\">My Ingredients</a></li>\n");
      out.write("                                <li><a href=\"user_add_new_category.jsp\">Add New Category</a></li>\n");
      out.write("\n");
      out.write("                                ");


                                    Criteria c = s1.createCriteria(Notification.class);
                                    c.add(Restrictions.eq("user", u));
                                    c.add(Restrictions.eq("status", "Unread"));
                                    List<Notification> n_list = c.list();

                                    int len = n_list.size();
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <li><a href=\"user_notifications.jsp\">Notifications \n");
      out.write("                                        ");
if (len != 0) {
      out.write("\n");
      out.write("                                        <span class=\"badge badge-info\">");
      out.print(len);
      out.write("</span> \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-header\"> <a href=\"#\" data-toggle=\"collapse\" data-target=\"#menu2\"><strong>Account</strong></a>\n");
      out.write("\n");
      out.write("                            <ul class=\"nav nav-stacked collapse\" id=\"menu2\">\n");
      out.write("                                <li><a href=\"user_profile.jsp\">My Profile</a></li>\n");
      out.write("                                <li><a href=\"#\">Change Password</a></li>\n");
      out.write("                                <li><a href=\"SignOut\">Sign Out</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /col-3 -->\n");
      out.write("                <div class=\"col-sm-9\">\n");
      out.write("\n");
      out.write("                    <!-- column 2 -->\n");
      out.write("\n");
      out.write("                    <strong><i class=\"glyphicon glyphicon-dashboard\"></i> My Kitchen Dashboard</strong>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        if (request.getParameter("msg") != null) {
                            if (request.getParameter("msg").equals("success")) {
                    
      out.write("\n");
      out.write("                    <div class=\"alert alert-success fade in\">\n");
      out.write("                        <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("                        <strong>Success!</strong> Ingredient added successfully.\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
} else if (request.getParameter("msg").equals("exists")) {
      out.write("\n");
      out.write("                    <div class=\"alert alert-warning fade in\">\n");
      out.write("                        <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("                        <strong>Duplicate!</strong> Ingredient already exists.\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
  } else if (request.getParameter("msg").equals("notexists")) {
      out.write("\n");
      out.write("                    <div class=\"alert alert-danger fade in\">\n");
      out.write("                        <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("                        <strong>Error!</strong> Ingredient you entered does not exist.\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    ");
  } else if (request.getParameter("msg").equals("error")) {
      out.write("\n");
      out.write("                    <div class=\"alert alert-danger fade in\">\n");
      out.write("                        <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("                        <strong>Error!</strong> An error occurred while adding the ingredient.\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
            }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div align=\"center\"><h1><small id=\"\">Request for a Recipe</small></h1></div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <ul class=\"list-group\">\n");
      out.write("                                ");

                                    Criteria c1 = s1.createCriteria(MyIngredient.class);
                                    c1.add(Restrictions.eq("user", u));
                                    List<MyIngredient> mi_list = c1.list();

                                    for (MyIngredient mi : mi_list) {
                                        Ingredient i = mi.getIngredient();
                                
      out.write("\n");
      out.write("                                <li class=\"list-group-item\">");
      out.print(i.getName());
      out.write("</li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-8\">\n");
      out.write("                            <form action=\"AddMyIngredient\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"text\" name=\"ing\" id=\"iding\" class=\"form-control\" placeholder=\"Enter ingredient\"/>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <button class=\"btn btn-default btn-block\" type=\"submit\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-plus\"></span> Add Ingredient\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!--/col-span-9-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /Main -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Beginning of footer-->\n");
      out.write("        <footer class=\"footer-distributed\">\n");
      out.write("\n");
      out.write("            <div class=\"footer-right\">\n");
      out.write("\n");
      out.write("                <a href=\"https://www.facebook.com/kitchenhuntr/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a href=\"https://twitter.com/kitchenhuntr\" target=\"_blank\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a href=\"https://github.com/Vini2/KitchenHunt\" target=\"_blank\"><i class=\"fa fa-github\"></i></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-left\">\n");
      out.write("\n");
      out.write("                <p class=\"footer-links\">\n");
      out.write("                    <a href=\"index.jsp\">Home</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"recipe_search.jsp\">Recipes</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"about.jsp\">About</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"contact_us.jsp\">Contact</a>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>Kitchen Hunt &copy; 2016</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("        <!--End of footer-->\n");
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"js/sidebar.js\"></script>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
