/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.CuisineCategory;
import HibFiles.FoodCategory;
import HibFiles.HealthCategory;
import HibFiles.Ingredient;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.RecipeHasIngredient;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "PostRecipe", urlPatterns = {"/PostRecipe"})
public class PostRecipe extends HttpServlet {

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

            String recipe_name = request.getParameter("recipe_name");
            String recipe_skill = request.getParameter("recipe_skill");
            String recipe_qty = request.getParameter("recipe_qty");
            String recipe_preptime = request.getParameter("recipe_preptime");
            String recipe_mealtype = request.getParameter("recipe_mealtype");
            String recipe_cuisine = request.getParameter("recipe_cuisine");
            String recipe_healthcat = request.getParameter("recipe_healthcat");

            String recipe_ing1 = request.getParameter("recipe_ing1");
            String recipe_ing1_qty = request.getParameter("recipe_ing1_qty");
            String recipe_ing1_unit = request.getParameter("recipe_ing1_unit");

            String recipe_ing2 = request.getParameter("recipe_ing2");
            String recipe_ing2_qty = request.getParameter("recipe_ing2_qty");
            String recipe_ing2_unit = request.getParameter("recipe_ing2_unit");

            String recipe_ing3 = request.getParameter("recipe_ing3");
            String recipe_ing3_qty = request.getParameter("recipe_ing3_qty");
            String recipe_ing3_unit = request.getParameter("recipe_ing3_unit");

            String recipe_ing4 = request.getParameter("recipe_ing4");
            String recipe_ing4_qty = request.getParameter("recipe_ing4_qty");
            String recipe_ing4_unit = request.getParameter("recipe_ing4_unit");

            String recipe_directions = request.getParameter("recipe_directions");
            
            System.out.println(recipe_name);
            System.out.println(recipe_cuisine);
            
            System.out.println(recipe_ing1+" "+recipe_ing1_qty+" "+recipe_ing1_unit);

            String msg = null;

            if (recipe_cuisine == null) {
                msg = "Error";
            } else if (recipe_mealtype == null) {
                msg = "Error";
            } else if (recipe_healthcat == null) {
                msg = "Error";
            } else if (recipe_skill == null) {
                msg = "Error";
            } else {

                Session s = PoolManager.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();

                CuisineCategory cc = (CuisineCategory) s.load(CuisineCategory.class, Integer.parseInt(recipe_cuisine));
                FoodCategory fc = (FoodCategory) s.load(FoodCategory.class, Integer.parseInt(recipe_mealtype));
                HealthCategory hc = (HealthCategory) s.load(HealthCategory.class, Integer.parseInt(recipe_healthcat));

                Recipe r = new Recipe();
                r.setName(recipe_name);
                r.setPreparingTime(recipe_preptime);
                r.setServingQuantity(Integer.parseInt(recipe_qty));
                r.setSkillLevel(recipe_skill);
                r.setOverallRating(0);
                r.setNotes("New");
                r.setDirections(recipe_directions);

                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

                r.setUser(ul.getUser());
                r.setFoodCategory(fc);
                r.setCuisineCategory(cc);
                r.setHealthCategory(hc);

                s.save(r);

                request.getSession().setAttribute("recipe", r);

                Criteria c = s.createCriteria(Ingredient.class);
                
                c.add(Restrictions.eq("name", recipe_ing1));
                Ingredient i1 = (Ingredient) c.uniqueResult();

                if (i1 == null) {
                    i1 = new Ingredient();
                    i1.setName(recipe_ing1);
                    s.save(i1);
                }
                
                c.add(Restrictions.eq("name", recipe_ing2));
                Ingredient i2 = (Ingredient) c.uniqueResult();

                if (i2 == null) {
                    i2 = new Ingredient();
                    i2.setName(recipe_ing2);
                    s.save(i2);
                }
                
                c.add(Restrictions.eq("name", recipe_ing3));
                Ingredient i3 = (Ingredient) c.uniqueResult();

                if (i3 == null) {
                    i3 = new Ingredient();
                    i3.setName(recipe_ing3);
                    s.save(i3);
                }
                
                c.add(Restrictions.eq("name", recipe_ing4));
                Ingredient i4 = (Ingredient) c.uniqueResult();

                if (i4 == null) {
                    i4 = new Ingredient();
                    i4.setName(recipe_ing4);
                    s.save(i4);
                }
                
                RecipeHasIngredient rhi1 = new RecipeHasIngredient();
                rhi1.setIngredient(i1);
                rhi1.setManiIngredient(Boolean.TRUE);
                rhi1.setRecipe(r);
                rhi1.setQuantity(Double.parseDouble(recipe_ing1_qty));
                s.save(rhi1);
                
                RecipeHasIngredient rhi2 = new RecipeHasIngredient();
                rhi2.setIngredient(i2);
                rhi2.setManiIngredient(Boolean.TRUE);
                rhi2.setRecipe(r);
                rhi2.setQuantity(Double.parseDouble(recipe_ing2_qty));
                s.save(rhi2);
                
                RecipeHasIngredient rhi3 = new RecipeHasIngredient();
                rhi3.setIngredient(i3);
                rhi3.setManiIngredient(Boolean.TRUE);
                rhi3.setRecipe(r);
                rhi3.setQuantity(Double.parseDouble(recipe_ing3_qty));
                s.save(rhi3);
                
                RecipeHasIngredient rhi4 = new RecipeHasIngredient();
                rhi4.setIngredient(i4);
                rhi4.setManiIngredient(Boolean.TRUE);
                rhi4.setRecipe(r);
                rhi4.setQuantity(Double.parseDouble(recipe_ing4_qty));
                s.save(rhi4);
                
                t.commit();
                
                msg="success";
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
