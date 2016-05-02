/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.LoginSession;
import HibFiles.PoolManager;
import HibFiles.UserLogin;
import HibFiles.UserType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class SignIn extends HttpServlet {

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

        System.out.println("inside servlet");

        String msg = null;

        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            System.out.println(email + " " + password);

            request.getSession().invalidate();

            Session s = PoolManager.getSessionFactory().openSession();

            Transaction t = s.beginTransaction();

            Criteria c = s.createCriteria(UserLogin.class);
            c.add(Restrictions.eq("email", request.getParameter("email")));
            UserLogin ul = (UserLogin) c.uniqueResult();

            if (ul == null) {
                msg = "Error1";

            } else if (!Security.decrypt(ul.getPassword()).equals(request.getParameter("password"))) {
                msg = "Error2";
            
            } else if (ul.getUser().getUserType().getTypeName().equals("User") && ul.getSystemStatus().getStatusName().equals("Active")) {

                request.getSession().invalidate();

                request.getSession().setAttribute("user", ul);

                LoginSession ls = new LoginSession();
                ls.setInTime(new Date());
                ls.setOutTime(new Date());
                ls.setIpAddress(request.getRemoteHost());
                ls.setUserLogin(ul);

                s.save(ls);

                request.getSession().setAttribute("ses", ls);

                t.commit();
                
                msg = "success";
                
            } else {
                msg="Error3";
            }

            out.write(msg);

        } catch (Exception e) {
            throw new ServletException(e);
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
