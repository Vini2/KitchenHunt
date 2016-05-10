/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.PoolManager;
import HibFiles.Rating;
import HibFiles.Recipe;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class PostRating extends HttpServlet {

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

        String msg = "";

        try {

            //Get attributes from http request
            String rid = request.getParameter("rid");
            String rating = request.getParameter("rating");

            System.out.println("Rating for recipe rid = " + rid + " is " + rating);

            //Create hibernate session
            Session s = PoolManager.getSessionFactory().openSession();

            //Initiate transaction
            Transaction t = s.beginTransaction();

            //Load recipe with given rid
            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(rid));

            Double d = Double.parseDouble(rating);
            int q = d.intValue();

            //Get currently logged in user
            UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

            Criteria c1 = s.createCriteria(Rating.class);
            c1.add(Restrictions.eq("recipe", r));
            c1.add(Restrictions.eq("user", ul.getUser()));
            Rating rt = (Rating) c1.uniqueResult();

            if (rt == null) {

                //Create rating object
                Rating rat = new Rating();
                rat.setRecipe(r);
                rat.setStars(q);
                rat.setUser(ul.getUser());
                //Save rating object
                s.save(rat);

                Criteria c2 = s.createCriteria(Rating.class);
                c2.add(Restrictions.eq("recipe", r));
                List<Rating> rl = c2.list();

                int tot_rating = 0;

                for (Rating ra : rl) {
                    tot_rating += ra.getStars();
                }

                int overall_rating = tot_rating / rl.size();

                r.setOverallRating(overall_rating);
                s.update(r);

                t.commit();

                msg = "success";

            } else {
                msg = "Error";
            }

            out.write(msg);

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
