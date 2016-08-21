package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HibFiles.FoodCategory;
import HibFiles.Request;
import HibFiles.Recipe;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import HibFiles.User;
import org.hibernate.Session;
import HibFiles.PoolManager;
import HibFiles.UserLogin;

public final class admin_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Kitchen Hunt - Administrator Dashboard</title>\n");
      out.write("\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("\n");
      out.write("        <meta name=\"generator\" content=\"Bootply\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                <script src=\"//html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Other scripts -->\n");
      out.write("        <link href=\"font-awesome-4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/footer-distributed.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/myjavascript.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--Beginning of navigation bar-->\n");
      out.write("        <!-- header -->\n");
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
      out.write("                <div class=\"navbar-collapse collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                        <li><a href=\"AdminSignOut\"><i class=\"glyphicon glyphicon-lock\"></i> Sign Out</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /container -->\n");
      out.write("        </nav>\n");
      out.write("        <!-- /Header -->\n");
      out.write("        <!--End of navigation bar-->\n");
      out.write("\n");
      out.write("        <!-- Main -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <!-- Left column -->\n");
      out.write("                    <ul class=\"nav nav-stacked\">\n");
      out.write("                        <li class=\"nav-header\"> <a href=\"#\" data-toggle=\"collapse\" data-target=\"#userMenu\"><strong>Recipes</strong></a>\n");
      out.write("                            <ul class=\"nav nav-stacked collapse in\" id=\"userMenu\">\n");
      out.write("                                <li><a href=\"admin_publish_recipe.jsp\">Publish Recipes</a></li>\n");
      out.write("                                <li><a href=\"admin_manage_category.jsp\">Manage Categories</a></li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-header\"> <a href=\"#\" data-toggle=\"collapse\" data-target=\"#menu2\"><strong>Users</strong></a>\n");
      out.write("\n");
      out.write("                            <ul class=\"nav nav-stacked collapse\" id=\"menu2\">\n");
      out.write("                                <li><a href=\"admin_manage_users.jsp\">Manage Users</a></li>\n");
      out.write("                                <li><a href=\"admin_manage_admins.jsp\">Manage Administrators</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /col-3 -->\n");
      out.write("                <div class=\"col-sm-9\">\n");
      out.write("\n");
      out.write("                    <a href=\"admin_home.jsp\"><strong><i class=\"glyphicon glyphicon-dashboard\"></i> Administrator Dashboard</strong></a>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                ");
                                    Criteria c = s.createCriteria(User.class);
                                    c.add(Restrictions.between("registerDate", new Date(), new Date()));
                                    List<User> u_list = c.list();

                                
      out.write("\n");
      out.write("                                <div class=\"well\">\n");
      out.write("                                    <h4>New Users Registered Today <span class=\"badge pull-right\">");
      out.print(u_list.size());
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                    ");
if (u_list.size() != 0) {
      out.write("\n");
      out.write("                                    <table class=\"table table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Name</th>\n");
      out.write("                                                <th>Mobile</th>\n");
      out.write("                                                <th>Address</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                for (User us : u_list) {
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(us.getFname());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(us.getMobile());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(us.getAddress());
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                    ");
} else {
      out.write("\n");
      out.write("                                    No new users\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                ");

                                    Criteria c1 = s.createCriteria(Recipe.class);
                                    c1.add(Restrictions.eq("status", "New"));
                                    List<Recipe> r_list = c1.list();
                                
      out.write("\n");
      out.write("                                <div class=\"well\">\n");
      out.write("                                    <h4>New Recipes Pending to be Published <span class=\"badge pull-right\">");
      out.print(r_list.size());
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                    ");
if (r_list.size() != 0) {
      out.write("\n");
      out.write("                                    <table class=\"table table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Recipe Name</th>\n");
      out.write("                                                <th>Posted By</th>\n");
      out.write("                                                <th>View Recipe</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                for (Recipe recipe : r_list) {
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(recipe.getName());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(recipe.getUser().getFname());
      out.write("</td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <a href=\"admin_view_recipe.jsp?rid=");
      out.print(recipe.getIdrecipe());
      out.write("\" class=\"btn btn-primary\" role=\"button\">View</a> \n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                    ");
} else {
      out.write("\n");
      out.write("                                    No pending recipes\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <!-- center left-->\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4>Reports on Posted Recipes</h4></div>\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                                    ");

                                        Criteria c0 = s.createCriteria(Recipe.class);
                                        List<Recipe> recipe_list = c0.list();

                                        if(recipe_list.size()!=0){
                                        Criteria cfc = s.createCriteria(FoodCategory.class);
                                        List<FoodCategory> fc_list = cfc.list();

                                        for (FoodCategory fc : fc_list) {
                                            Criteria cr1 = s.createCriteria(Recipe.class);
                                            cr1.add(Restrictions.eq("foodCategory", fc));
                                            List<Recipe> cr1_list = cr1.list();

                                            int perc = cr1_list.size() / recipe_list.size() * 100;

                                    
      out.write("\n");
      out.write("                                    <small>");
      out.print(fc.getCategoryName());
      out.write("</small>\n");
      out.write("                                    <div class=\"progress\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"72\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: ");
      out.print(perc);
      out.write("%\">\n");
      out.write("                                            <span class=\"sr-only\">");
      out.print(perc);
      out.write("% Complete</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    ");
}}else{
      out.write("\n");
      out.write("                                    No recipes found.\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <!--/panel-body-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--/panel-->\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!--/col-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4>Recipe Requests</h4></div>\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                                    ");

                                        Criteria cr = s.createCriteria(Request.class);
                                        cr.add(Restrictions.between("date", new Date(), new Date()));
                                        cr.add(Restrictions.eq("status", "Not Responded"));
                                        List<Request> req_list = cr.list();

                                        if (req_list.size() != 0) {
                                    
      out.write("\n");
      out.write("                                    <table class=\"table table-striped\">\n");
      out.write("                                        <tbody>\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Recipe Name</th>\n");
      out.write("                                                <th>Requested By</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        ");
for (Request req : req_list) {
      out.write("\n");
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>");
      out.print(req.getRecipeName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(req.getUser().getFname());
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                    ");
} else {
      out.write("\n");
      out.write("                                    No requests posted\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!--/col-span-6-->\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!--/row-->\n");
      out.write("\n");
      out.write("                    <hr>\n");
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
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        <!--End of footer-->\n");
      out.write("        <!-- /.modal -->\n");
      out.write("        <!-- script references -->\n");
      out.write("        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("    </body>\n");
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
