package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import HibFiles.MyKitchen;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.User;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class AddToMyKitchen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String msg = null;

        try {

            String rid = request.getParameter("rid");
            System.out.println(rid);

            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

            User u = ul.getUser();

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();

            //Initiate transaction
            Transaction t = s.beginTransaction();

            //Get recipe
            Criteria c = s.createCriteria(Recipe.class);
            c.add(Restrictions.eq("idrecipe", Integer.parseInt(rid)));
            Recipe r = (Recipe) c.uniqueResult();

            Criteria c1 = s.createCriteria(MyKitchen.class);
            c1.add(Restrictions.eq("recipe", r));
            c1.add(Restrictions.eq("user", u));
            MyKitchen mk = (MyKitchen) c1.uniqueResult();

            if (mk == null) {
                mk = new MyKitchen();
                mk.setRecipe(r);
                mk.setUser(u);

                s.save(mk);
                t.commit();

                msg = "success";
                
            } else {
                msg = "exists";
            }

            response.sendRedirect("view_recipe.jsp?rid=" + rid + "&msg=" + msg);

        } catch (Exception e) {
            throw new ServletException();
//            response.sendRedirect("view_recipe.jsp?rid=" + rid + "&msg=error");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
