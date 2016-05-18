/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.Image;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

            System.out.println("Inside Servlet");

            //Get attributes from http request
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

            String msg = null;

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items = upload.parseRequest(request);

            for (Object element : items) {
                FileItem fileitem = (FileItem) element;

                if (fileitem.isFormField()) {

                    if (fileitem.getFieldName().equals("recipe_name")) {
                        recipe_name = fileitem.getString();
                        System.out.println(recipe_name);
                    } else if (fileitem.getFieldName().equals("recipe_skill")) {
                        recipe_skill = fileitem.getString();
                        System.out.println(recipe_skill);
                    } else if (fileitem.getFieldName().equals("recipe_qty")) {
                        recipe_qty = fileitem.getString();
                        System.out.println(recipe_qty);
                    } else if (fileitem.getFieldName().equals("recipe_preptime")) {
                        recipe_preptime = fileitem.getString();
                        System.out.println(recipe_preptime);
                    } else if (fileitem.getFieldName().equals("recipe_mealtype")) {
                        recipe_mealtype = fileitem.getString();
                        System.out.println(recipe_mealtype);
                    } else if (fileitem.getFieldName().equals("recipe_cuisine")) {
                        recipe_cuisine = fileitem.getString();
                        System.out.println(recipe_cuisine);
                    }
                } else {

                    //Create hibernate session
                    Session s = PoolManager.getSessionFactory().openSession();

                    //Initiate transaction
                    Transaction t = s.beginTransaction();

                    Recipe r = (Recipe) s.load(Recipe.class, 1);

                    String path = "images/recipe/" + recipe_name + ".jpg";

                    File savedFile = new File(getServletContext().getRealPath("/") + path);
                    fileitem.write(savedFile);
                    
                    System.out.println(request.getServletPath());
                        Image im = new Image();

                        //save image into database
                        File file = new File(getServletContext().getRealPath("/") + path);
                        byte[] bFile = new byte[(int) file.length()];

                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            //convert file into array of bytes
                            fileInputStream.read(bFile);
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        im.setImageData(bFile);
                        im.setRecipe(r);
                        
                        s.save(im);
                        t.commit();
                }
            }

//            if (recipe_cuisine == null) {
//                msg = "Error";
//            } else if (recipe_mealtype == null) {
//                msg = "Error";
//            } else if (recipe_healthcat == null) {
//                msg = "Error";
//            } else if (recipe_skill == null) {
//                msg = "Error";
//            } else {
//
//                //Create hibernate session
//                Session s = PoolManager.getSessionFactory().openSession();
//                
//                //Initiate transaction
//                Transaction t = s.beginTransaction();
//
//                //Get cuisine category
//                CuisineCategory cc = (CuisineCategory) s.load(CuisineCategory.class, Integer.parseInt(recipe_cuisine));
//                //Get food category
//                FoodCategory fc = (FoodCategory) s.load(FoodCategory.class, Integer.parseInt(recipe_mealtype));
//                //Get health category
//                HealthCategory hc = (HealthCategory) s.load(HealthCategory.class, Integer.parseInt(recipe_healthcat));
//
//                //Create recipe object and save it
//                Recipe r = new Recipe();
//                r.setName(recipe_name);
//                r.setPreparingTime(recipe_preptime);
//                r.setServingQuantity(Integer.parseInt(recipe_qty));
//                r.setSkillLevel(recipe_skill);
//                r.setOverallRating(0.0);
//                r.setRatedCount(0);
//                r.setNotes("New");
//                r.setDirections(recipe_directions);
//
//                UserLogin ul = (UserLogin) request.getSession().getAttribute("user");
//
//                r.setUser(ul.getUser());
//                r.setFoodCategory(fc);
//                r.setCuisineCategory(cc);
//                r.setHealthCategory(hc);
//
//                s.save(r);
//
//                request.getSession().setAttribute("recipe", r);
//
//                //Save ingredients 
//                Criteria c1 = s.createCriteria(Ingredient.class);
//                c1.add(Restrictions.eq("name", recipe_ing1));
//                Ingredient i1 = (Ingredient) c1.uniqueResult();
//
//                if (i1 == null) {
//                    i1 = new Ingredient();
//                    i1.setName(recipe_ing1);
//                    s.save(i1);
//                }
//                
//                Criteria c2 = s.createCriteria(Ingredient.class);
//                c2.add(Restrictions.eq("name", recipe_ing2));
//                Ingredient i2 = (Ingredient) c2.uniqueResult();
//
//                if (i2 == null) {
//                    i2 = new Ingredient();
//                    i2.setName(recipe_ing2);
//                    s.save(i2);
//                }
//                
//                Criteria c3 = s.createCriteria(Ingredient.class);
//                c3.add(Restrictions.eq("name", recipe_ing3));
//                Ingredient i3 = (Ingredient) c3.uniqueResult();
//
//                if (i3 == null) {
//                    i3 = new Ingredient();
//                    i3.setName(recipe_ing3);
//                    s.save(i3);
//                }
//                
//                Criteria c4 = s.createCriteria(Ingredient.class);
//                c4.add(Restrictions.eq("name", recipe_ing4));
//                Ingredient i4 = (Ingredient) c4.uniqueResult();
//
//                if (i4 == null) {
//                    i4 = new Ingredient();
//                    i4.setName(recipe_ing4);
//                    s.save(i4);
//                }
//                
//                Unit u1 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing1_unit));
//                
//                RecipeHasIngredient rhi1 = new RecipeHasIngredient();
//                rhi1.setIngredient(i1);
//                rhi1.setMainIngredient(Boolean.TRUE);
//                rhi1.setRecipe(r);
//                rhi1.setQuantity(Double.parseDouble(recipe_ing1_qty));
//                rhi1.setUnit(u1);
//                s.save(rhi1);
//                
//                Unit u2 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing2_unit));
//                
//                RecipeHasIngredient rhi2 = new RecipeHasIngredient();
//                rhi2.setIngredient(i2);
//                rhi2.setMainIngredient(Boolean.TRUE);
//                rhi2.setRecipe(r);
//                rhi2.setQuantity(Double.parseDouble(recipe_ing2_qty));
//                rhi2.setUnit(u2);
//                s.save(rhi2);
//                
//                Unit u3 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing3_unit));
//                
//                RecipeHasIngredient rhi3 = new RecipeHasIngredient();
//                rhi3.setIngredient(i3);
//                rhi3.setMainIngredient(Boolean.TRUE);
//                rhi3.setRecipe(r);
//                rhi3.setQuantity(Double.parseDouble(recipe_ing3_qty));
//                rhi3.setUnit(u3);
//                s.save(rhi3);
//                
//                Unit u4 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing4_unit));
//                
//                RecipeHasIngredient rhi4 = new RecipeHasIngredient();
//                rhi4.setIngredient(i4);
//                rhi4.setMainIngredient(Boolean.TRUE);
//                rhi4.setRecipe(r);
//                rhi4.setQuantity(Double.parseDouble(recipe_ing4_qty));
//                rhi4.setUnit(u4);
//                s.save(rhi4);
//                
//                t.commit();
//                
//                msg="success";
//            }
            out.write("success");

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
