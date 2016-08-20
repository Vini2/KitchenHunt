/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.PoolManager;
import HibFiles.SystemStatus;
import HibFiles.User;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
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
public class ActivateAccount extends HttpServlet {

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

        try {

            //get parameter from request
            String id = request.getParameter("id");

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();

            //Initiate transaction
            Transaction t = s.beginTransaction();
            
            //Load user
            User u = (User) s.load(User.class, Integer.parseInt(id));

            Set<UserLogin> user_set = u.getUserLogins();
            Iterator iter = user_set.iterator();
            UserLogin user_ul = (UserLogin) iter.next();
            
            Criteria c = s.createCriteria(SystemStatus.class);
            c.add(Restrictions.eq("statusName", "Active"));
            SystemStatus ss = (SystemStatus) c.uniqueResult();
            
            //Set system status active
            user_ul.setSystemStatus(ss);

            //Update object
            s.update(user_ul);
            
            //Commit changes
            t.commit();

            response.sendRedirect("admin_manage_users.jsp");

        } catch (Exception e) {
            throw new ServletException();
//            response.sendRedirect("user_ingredients.jsp?msg=error");
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
