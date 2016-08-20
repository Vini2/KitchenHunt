/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.MyIngredient;
import HibFiles.Notification;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.RecipeHasIngredient;
import HibFiles.Request;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
public class PublishRecipe extends HttpServlet {

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
            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();
            
            //Initiate transaction
            Transaction t = s.beginTransaction();

            //Get attributes from http request and load recipe
            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(request.getParameter("rid")));

            r.setStatus("Published");

            s.update(r);

            //Notify the user that the recipe was published
            Notification not = new Notification();
            not.setDate(new Date());
            not.setCategory("Recipe Published");
            not.setStatus("Unread");
            not.setUser(r.getUser());
            not.setNotification("Your recipe names " + r.getName() + " has been published successfully.");
            s.save(not);

            //Check for requests posted for the recipe
            Criteria cr = s.createCriteria(Request.class);
            cr.add(Restrictions.eq("recipeName", r.getName()));
            List<Request> req_list = cr.list();

            for (Request request1 : req_list) {

                String posted_user1 = r.getUser().getIduser() + "";
                String us1 = request1.getUser().getIduser() + "";

                System.out.println(posted_user1 + " " + us1);

                if (!posted_user1.equals(us1)) {

                    //Notify requested users
                    Notification not1 = new Notification();
                    not1.setUser(request1.getUser());
                    not1.setCategory("Recipe posted for Request");
                    not1.setDate(new Date());
                    not1.setStatus("Unread");
                    not1.setNotification("A recipe named " + r.getName() + " has been posted by " + r.getUser().getFname() + " in response to your request.");
                    s.save(not1);

                    request1.setStatus("Responded");
                    s.update(request1);
                }

            }

            Set<RecipeHasIngredient> ing_set = r.getRecipeHasIngredients();

            for (RecipeHasIngredient rhi : ing_set) {

                Criteria cm1 = s.createCriteria(MyIngredient.class);
                cm1.add(Restrictions.eq("ingredient", rhi.getIngredient()));
                List<MyIngredient> mi1_list = cm1.list();

                for (MyIngredient mi : mi1_list) {

                    String posted_user = r.getUser().getIduser() + "";
                    String us = mi.getUser().getIduser() + "";

                    System.out.println(posted_user + " " + us);

                    if (!posted_user.equals(us)) {

                        //Notify users
                        Notification n = new Notification();
                        n.setDate(new Date());
                        n.setCategory("New Recipe Posted");
                        n.setStatus("Unread");
                        n.setUser(mi.getUser());
                        n.setNotification("A new recipe named " + r.getName() + " containing the ingredient " + mi.getIngredient().getName() + " has been posted by " + ul.getUser().getFname());
                        s.save(n);
                    }
                }
            }

            t.commit();

            response.sendRedirect("admin_view_recipe.jsp?rid=" + r.getIdrecipe() + "&msg=success");

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
