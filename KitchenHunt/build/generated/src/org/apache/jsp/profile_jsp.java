package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import HibFiles.PoolManager;
import HibFiles.UserLogin;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Kitchen Hunt</title>\n");
      out.write("        \n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            } else {
                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
                Session s1 = PoolManager.getSessionFactory().openSession();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("\n");
      out.write("        <link href=\"css/sidebar.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"font-awesome-4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/footer-distributed.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/myjavascript.js\"></script>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                        <!--<img alt=\"Brand\" src=\"images/KitchenHunt.png\" height=\"32\" width=\"auto\">-->\n");
      out.write("                        <a class=\"navbar-brand\" href=\"index.jsp\">Kitchen Hunt</a>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"recipe_search.jsp\">Recipe Search</a></li>\n");
      out.write("                        <li><a href=\"#\">Help</a></li>\n");
      out.write("                        <li><a href=\"#\">About</a></li>\n");
      out.write("\n");
      out.write("                        ");

                            if (request.getSession().getAttribute("user") != null) {
                                
                        
      out.write("\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> ");
      out.print(ul.getUser().getName());
      out.write("</a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                                <li><a href=\"SignOut\">Sign Out</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> My Kitchen</a>\n");
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
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content modal-sm\"  >\n");
      out.write("                    <div class=\"modal-header\" style=\"text-align: center\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h3 class=\"modal-title\">Sign In</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\" align=\"left\">\n");
      out.write("                        <form role=\"form\" action=\"\" onsubmit=\"signIn(this); return false;\" method=\"POST\" id=\"testform\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email address:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"signin_email\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"signin_password\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label><input type=\"checkbox\"> Remember me</label>\n");
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
      out.write("        <div class=\"page-header\" align=\"center\">\n");
      out.write("            <h1><small>Profile</small></h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"width:50%; margin:0 auto;\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" onsubmit=\"update(this); return false;\" method=\"POST\" id=\"testform\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"email\" disabled>Name:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"profile_name\" name=\"profile_name\" placeholder=\"\" value=\"");
      out.print(ul.getUser().getName());
      out.write("\" disabled required>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"email\" disabled>Address:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"profile_address\" name=\"profile_address\" placeholder=\"\" disabled required>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"email\" disabled>Telephone:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"profile_telephone\" name=\"profile_telephone\" placeholder=\"\" value=\"");
      out.print(ul.getUser().getMobile());
      out.write("\" disabled required>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\"> \n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10\" align=\"right\" id=\"action_button\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-success\" onclick=\"enable()\" id='btn_edit'>Edit</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\" id=\"btn_update\" style=\"display: none\">Update</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br><br><br><br><br><br>\n");
      out.write("\n");
      out.write("        <footer class=\"footer-distributed\">\n");
      out.write("\n");
      out.write("            <div class=\"footer-right\">\n");
      out.write("\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-github\"></i></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-left\">\n");
      out.write("\n");
      out.write("                <p class=\"footer-links\">\n");
      out.write("                    <a href=\"#\">Home</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"#\">Recipe Search</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"#\">Help</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"#\">About</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"#\">My Kitchen</a>\n");
      out.write("                    ·\n");
      out.write("                    <a href=\"#\">Contact</a>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>Kitchen Hunt &copy; 2016</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </footer>\n");
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
