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
import HibFiles.SystemStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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

            String recipe_inc_ing = request.getParameter("recipe_inc_ing");
            String recipe_ex_ing = request.getParameter("recipe_ex_ing");
            String recipe_mealtype = request.getParameter("recipe_mealtype");
            String recipe_cusine = request.getParameter("recipe_cusine");
            String recipe_healthcat = request.getParameter("recipe_healthcat");

            request.getSession().removeAttribute("perceList");
            request.getSession().removeAttribute("recipeList");

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();

            //Initiate transaction
            Transaction t = s.beginTransaction();

            Criteria c = s.createCriteria(Recipe.class);
            c.add(Restrictions.eq("status", "Published"));

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

            c.addOrder(Order.asc("name"));

            List<Recipe> lr = c.list();

            ArrayList recipe_list = new ArrayList();

            for (Recipe r : lr) {

                //System.out.println(r.getName() + " - " + r.getFoodCategory().getCategoryName() + " " + r.getCuisineCategory().getCuisineName() + " " + r.getHealthCategory().getCategoryName());
                Set<RecipeHasIngredient> ingredients = r.getRecipeHasIngredients();

                if (!recipe_inc_ing.equals("") & !recipe_ex_ing.equals("")) {
                    boolean inc_ing_valid = false;
                    boolean ex_ing_valid = true;

                    for (RecipeHasIngredient ingredient : ingredients) {
                        if (ingredient.getIngredient().getName().equals(recipe_inc_ing)) {
                            inc_ing_valid = true;
                        }
                        if (ingredient.getIngredient().getName().equals(recipe_ex_ing)) {
                            ex_ing_valid = false;
                        }
                    }

                    if (inc_ing_valid & ex_ing_valid) {
                        recipe_list.add(r.getIdrecipe());
                    }
                } else if (!recipe_inc_ing.equals("") & recipe_ex_ing.equals("")) {
                    for (RecipeHasIngredient ingredient : ingredients) {
                        if (ingredient.getIngredient().getName().equals(recipe_inc_ing)) {
                            recipe_list.add(r.getIdrecipe());
                            break;
                        }
                    }
                } else if (!recipe_ex_ing.equals("") & recipe_inc_ing.equals("")) {
                    boolean ex_ing_valid = false;
                    for (RecipeHasIngredient ingredient : ingredients) {
                        if (ingredient.getIngredient().getName().equals(recipe_ex_ing)) {
                            ex_ing_valid = true;
                            break;
                        }

                    }
                    if (!ex_ing_valid) {
                        recipe_list.add(r.getIdrecipe());
                    }
                } else {
                    recipe_list.add(r.getIdrecipe());
                }
            }

            ArrayList perc_list = new ArrayList();

            if (!recipe_inc_ing.equals("") && recipe_ex_ing.equals("")) {

                Criteria c1 = s.createCriteria(Recipe.class);
                Criteria rhiCrit = c1.createCriteria("recipeHasIngredients");
                Criteria ingdCrit = rhiCrit.createCriteria("ingredient");
                ingdCrit.add(Restrictions.eq("name", recipe_inc_ing));
                List<Recipe> r_list = c1.list();

                for (Recipe recipe : r_list) {

                    double total_weight = 0.0;
                    double ing_weight = 1.0;

                    Set<RecipeHasIngredient> ingredients = recipe.getRecipeHasIngredients();
                    for (RecipeHasIngredient ingredient : ingredients) {
                        total_weight = total_weight + ingredient.getQuantity();
                        if (ingredient.getIngredient().getName().equals(recipe_inc_ing)) {
                            ing_weight = ingredient.getQuantity();
                        }
                    }

                    Double percentage = ing_weight / total_weight * 100;

                    perc_list.add(percentage.intValue());

                }
                
                Comparator comparator = Collections.reverseOrder();
                Collections.sort(perc_list, comparator);
                

                perc_list.add(0, recipe_inc_ing);
                

                request.getSession().setAttribute("perceList", perc_list);

            }

            request.getSession().setAttribute("recipeList", recipe_list);

            //System.out.println("recipe list set");
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
