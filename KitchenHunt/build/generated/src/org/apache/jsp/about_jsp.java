package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HibFiles.UserLogin;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\r\n");
      out.write("        <title>Kitchen Hunt - About</title>\r\n");
      out.write("\r\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            request.getSession().removeAttribute("recipeList");
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Latest compiled and minified CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Optional theme -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Other scripts -->\r\n");
      out.write("        <link href=\"css/sidebar.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"font-awesome-4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/footer-distributed.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/myjavascript.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!--Beginning of navigation bar-->\r\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <!--<img alt=\"Brand\" src=\"images/KitchenHunt.png\" height=\"32\" width=\"auto\">-->\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\"><img alt=\"Kitchen Hunt\" src=\"images/KitchenHunt.png\" height=\"28\" width=\"auto\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                        <li><a href=\"recipe_search.jsp\">Recipe Search</a></li>\r\n");
      out.write("                        <li><a href=\"help.jsp\">Help</a></li>\r\n");
      out.write("                        <li><a id=\"idabout\" href=\"about.jsp\">About</a></li>\r\n");
      out.write("                        <li><a id=\"idcontact\" href=\"contact_us.jsp\">Contact Us</a></li>\r\n");
      out.write("\r\n");
      out.write("                        ");

                            if (request.getSession().getAttribute("user") != null) {
                                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                        
      out.write("\r\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> ");
      out.print(ul.getUser().getFname());
      out.write("<span class=\"caret\"></span></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"user_dashboard.jsp\">My Kitchen Dashboard</a></li>\r\n");
      out.write("                                <li><a href=\"SignOut\">Sign Out</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        ");
} else {
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> My Kitchen<span class=\"caret\"></span></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#signUpModal\">Sign Up</a></li>\r\n");
      out.write("                                <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#signInModal\">Sign In</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </div><!-- /.navbar-collapse -->\r\n");
      out.write("            </div><!-- /.container-fluid -->\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!--End of navigation bar-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Sign Up Modal -->\r\n");
      out.write("        <div id=\"signUpModal\" class=\"modal fade\" role=\"dialog\" align=\"center\">\r\n");
      out.write("            <div class=\"modal-dialog\" >\r\n");
      out.write("\r\n");
      out.write("                <!-- Modal content-->\r\n");
      out.write("                <div class=\"modal-content modal-sm\"  >\r\n");
      out.write("                    <div class=\"modal-header\" style=\"text-align: center\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                        <h3 class=\"modal-title\">Sign Up</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\" align=\"left\">\r\n");
      out.write("                        <form role=\"form\" action=\"\" onsubmit=\"signUp(this); return false;\" method=\"POST\" id=\"signup_form\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"name\">Name:</label>\r\n");
      out.write("                                <input type=\"name\" class=\"form-control\" name=\"signup_name\" id=\"idname\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"name\">Mobile:</label>\r\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"signup_mobile\" id=\"idmobile\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"email\">Email address:</label>\r\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"signup_email\" id=\"idemail\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"pwd\">Password:</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signup_password\" id=\"idpassword\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"pwd\">Confirm password:</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signup_confirmpassword\" id=\"idconfirmpassword\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div align=\"right\">\r\n");
      out.write("                                <input type=\"submit\" value=\"Sign Up\" class=\"btn btn-success btn-block\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Sign In Modal -->\r\n");
      out.write("        <div id=\"signInModal\" class=\"modal fade\" role=\"dialog\" align=\"center\">\r\n");
      out.write("            <div class=\"modal-dialog\" >\r\n");
      out.write("\r\n");
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
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- Modal content-->\r\n");
      out.write("                <div class=\"modal-content modal-sm\"  >\r\n");
      out.write("                    <div class=\"modal-header\" style=\"text-align: center\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                        <h3 class=\"modal-title\">Sign In</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\" align=\"left\">\r\n");
      out.write("                        <form role=\"form\" action=\"\" onsubmit=\"signIn(this); return false;\" method=\"POST\" id=\"signin_form\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"email\">Email address:</label>\r\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"signin_email\" value=\"");
      out.print(email);
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"pwd\">Password:</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signin_password\" value=\"");
      out.print(pass);
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"checkbox\">\r\n");
      out.write("                                <label><input type=\"checkbox\" id=\"rememberMe\"> Remember me</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div align=\"right\">\r\n");
      out.write("                                <input type=\"submit\" value=\"Sign In\" class=\"btn btn-success btn-block\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!--About details-->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"page-header\" align=\"center\">\r\n");
      out.write("                <h1><small id=\"profile_title\">About</small></h1>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"container\" align=\"center\">\r\n");
      out.write("            <img src=\"images/profile pic.png\" alt=\"\" width=\"250px\" height=\"auto\">\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <h4>Kitchen Hunt is a global cooking community where anyone can join and share their knowledge on cuisine.</h4>\r\n");
      out.write("            <h4>Anyone who is passionate about cooking and cuisine can join Kitchen Hunt.</h4>\r\n");
      out.write("            <h4>Now you do not have to go through huge recipe books.</h4>\r\n");
      out.write("            <h4>You can simply enter the ingredients you have in your kitchen and get the recipes you can make instantly.</h4>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--Beginning of footer-->\r\n");
      out.write("        <footer class=\"footer-distributed\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"footer-right\">\r\n");
      out.write("\r\n");
      out.write("                <a href=\"https://www.facebook.com/kitchenhuntr/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                <a href=\"https://twitter.com/kitchenhuntr\" target=\"_blank\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                <a href=\"https://github.com/Vini2/KitchenHunt\" target=\"_blank\"><i class=\"fa fa-github\"></i></a>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"footer-left\">\r\n");
      out.write("\r\n");
      out.write("                <p class=\"footer-links\">\r\n");
      out.write("                    <a href=\"index.jsp\">Home</a>\r\n");
      out.write("                    ·\r\n");
      out.write("                    <a href=\"recipe_search.jsp\">Recipes</a>\r\n");
      out.write("                    ·\r\n");
      out.write("                    <a href=\"about.jsp\">About</a>\r\n");
      out.write("                    ·\r\n");
      out.write("                    <a href=\"contact_us.jsp\">Contact</a>\r\n");
      out.write("                </p>\r\n");
      out.write("\r\n");
      out.write("                <p>Kitchen Hunt &copy; 2016</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </footer>\r\n");
      out.write("        <!--End of footer-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"js/sidebar.js\"></script>\r\n");
      out.write("</html>");
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
