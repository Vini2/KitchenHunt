/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.CuisineCategory;
import HibFiles.FoodCategory;
import HibFiles.HealthCategory;
import HibFiles.PoolManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import HibFiles.Unit;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class RemoveCategory extends HttpServlet {

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

            String id = request.getParameter("id");
            String type = request.getParameter("type");
            
            String msg = "";

            Session s = PoolManager.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            if (type.equals("fc")) {
                
                FoodCategory fc = (FoodCategory) s.load(FoodCategory.class, Integer.parseInt(id));
                s.delete(fc);
                t.commit();
                
            }
            else if (type.equals("cc")) {
                
                CuisineCategory cc = (CuisineCategory) s.load(CuisineCategory.class, Integer.parseInt(id));
                s.delete(cc);
                t.commit();
            }
            else if (type.equals("hc")) {
                
                HealthCategory hc = (HealthCategory) s.load(HealthCategory.class, Integer.parseInt(id));
                s.delete(hc);
                t.commit();
            }
            else if (type.equals("u")) {
                
                Unit u = (Unit) s.load(Unit.class, Integer.parseInt(id));
                s.delete(u);
                t.commit();
            }
            
            
            response.sendRedirect("admin_manage_category.jsp");

        } catch (Exception e) {
            throw new ServletException();
//            response.sendRedirect("user_add_new_category.jsp?msg=error");
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
