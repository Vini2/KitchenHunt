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
import HibFiles.Recipe;
import HibFiles.SystemStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class RecipeSearch extends HttpServlet {

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

            String recipe_mealtype = request.getParameter("recipe_mealtype");
            String recipe_cusine = request.getParameter("recipe_cusine");
            String recipe_healthcat = request.getParameter("recipe_healthcat");
            String recipe_exclude = request.getParameter("recipe_exclude");

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();

            //Initiate transaction
            Transaction t = s.beginTransaction();

            Criteria c = s.createCriteria(Recipe.class);
            
            if (!recipe_mealtype.equals("0")) {
                FoodCategory fc = (FoodCategory) s.load(FoodCategory.class, Integer.parseInt(recipe_mealtype));
                c.add(Restrictions.eq("foodCategory", fc));
            }
            
            if (!recipe_cusine.equals("0")) {
                CuisineCategory cc = (CuisineCategory) s.load(CuisineCategory.class, Integer.parseInt(recipe_cusine));
                c.add(Restrictions.eq("cuisineCategory", cc));
            }
            
            if (!recipe_healthcat.equals("0")) {
                HealthCategory hc = (HealthCategory) s.load(HealthCategory.class, Integer.parseInt(recipe_healthcat));
                c.add(Restrictions.eq("healthCategory", hc));
            }
            
            c.addOrder(Order.desc("idrecipe"));

            List<Recipe> lr = c.list();
            
            ArrayList recipe_list = new ArrayList();

            for (Recipe r : lr) {
                System.out.println(r.getName() + " - " + r.getFoodCategory().getCategoryName() + " " + r.getCuisineCategory().getCuisineName() + " " + r.getHealthCategory().getCategoryName());
                recipe_list.add(r.getIdrecipe());
                
            }
            
            request.getSession().removeAttribute("recipeList");
                    
            request.getSession().setAttribute("recipeList", recipe_list);
            
            System.out.println("recipe list set");
            
            //Send redirect to recipe_search.jsp
            response.sendRedirect("recipe_search.jsp");

        } catch (Exception e) {
            throw new ServletException();
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
