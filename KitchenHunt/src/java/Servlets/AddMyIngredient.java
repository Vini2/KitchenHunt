/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.FoodCategory;
import HibFiles.Ingredient;
import HibFiles.MyIngredient;
import HibFiles.PoolManager;
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
public class AddMyIngredient extends HttpServlet {

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

            String ing = request.getParameter("ing");
            ing = ing.trim();

            System.out.println(ing);

            String msg = "";

            Session s = PoolManager.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

            Criteria c = s.createCriteria(Ingredient.class);
            c.add(Restrictions.eq("name", ing));
            Ingredient i = (Ingredient) c.uniqueResult();

            if (i != null) {

                Criteria c1 = s.createCriteria(MyIngredient.class);
                c1.add(Restrictions.eq("ingredient", i));
                MyIngredient mi = (MyIngredient) c1.uniqueResult();
                
                if (mi==null) {
                    
                    MyIngredient mi_new = new MyIngredient();
                    mi_new.setIngredient(i);
                    mi_new.setUser(ul.getUser());
                    s.save(mi_new);
                    
                    t.commit();
                    msg = "success";
                }
                else{
                    msg = "exists";
                }

            } else {
                msg = "notexists";
            }

            response.sendRedirect("user_ingredients.jsp?msg=" + msg);

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
