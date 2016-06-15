/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.CuisineCategory;
import HibFiles.FoodCategory;
import HibFiles.HealthCategory;
import HibFiles.Image;
import HibFiles.Ingredient;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.RecipeHasIngredient;
import HibFiles.Unit;
import HibFiles.UserLogin;
import java.io.File;
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

            System.out.println("Inside Servlet");

            boolean isNum = true;

            String recipe_name = null;
            String recipe_skill = null;
            String recipe_qty = null;
            String recipe_preptime = null;
            String recipe_mealtype = null;
            String recipe_cuisine = null;
            String recipe_healthcat = null;

            String recipe_ing1 = null;
            String recipe_ing1_qty = null;
            String recipe_ing1_unit = null;

            String recipe_ing2 = null;
            String recipe_ing2_qty = null;
            String recipe_ing2_unit = null;

            String recipe_ing3 = null;
            String recipe_ing3_qty = null;
            String recipe_ing3_unit = null;

            String recipe_ing4 = null;
            String recipe_ing4_qty = null;
            String recipe_ing4_unit = null;

            String recipe_ing5 = null;
            String recipe_ing5_qty = null;
            String recipe_ing5_unit = null;

            String recipe_ing6 = null;
            String recipe_ing6_qty = null;
            String recipe_ing6_unit = null;

            String recipe_ing7 = null;
            String recipe_ing7_qty = null;
            String recipe_ing7_unit = null;

            String recipe_ing8 = null;
            String recipe_ing8_qty = null;
            String recipe_ing8_unit = null;

            String recipe_ing9 = null;
            String recipe_ing9_qty = null;
            String recipe_ing9_unit = null;

            String recipe_ing10 = null;
            String recipe_ing10_qty = null;
            String recipe_ing10_unit = null;

            String recipe_directions = null;

            FileItem image_file = null;

            String msg = null;

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items = upload.parseRequest(request);

            //Get attributes from http request
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
                    } else if (fileitem.getFieldName().equals("recipe_healthcat")) {
                        recipe_healthcat = fileitem.getString();
                        System.out.println(recipe_healthcat);
                    } else if (fileitem.getFieldName().equals("recipe_directions")) {
                        recipe_directions = fileitem.getString();
                        System.out.println(recipe_directions);

                    } else if (fileitem.getFieldName().equals("recipe_ing1")) {
                        recipe_ing1 = fileitem.getString();
                        System.out.println(recipe_ing1);
                    } else if (fileitem.getFieldName().equals("recipe_ing1_qty")) {
                        recipe_ing1_qty = fileitem.getString();
                        System.out.println(recipe_ing1_qty);
                        if (!NumberCheck.isNumeric(recipe_ing1_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing1_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing1_unit")) {
                        recipe_ing1_unit = fileitem.getString();
                        System.out.println(recipe_ing1_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing2")) {
                        recipe_ing2 = fileitem.getString();
                        System.out.println(recipe_ing2);
                    } else if (fileitem.getFieldName().equals("recipe_ing2_qty")) {
                        recipe_ing2_qty = fileitem.getString();
                        System.out.println(recipe_ing2_qty);
                        if (!NumberCheck.isNumeric(recipe_ing2_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing2_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing2_unit")) {
                        recipe_ing2_unit = fileitem.getString();
                        System.out.println(recipe_ing2_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing3")) {
                        recipe_ing3 = fileitem.getString();
                        System.out.println(recipe_ing3);
                    } else if (fileitem.getFieldName().equals("recipe_ing3_qty")) {
                        recipe_ing3_qty = fileitem.getString();
                        System.out.println(recipe_ing3_qty);
                        if (!NumberCheck.isNumeric(recipe_ing3_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing3_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing3_unit")) {
                        recipe_ing3_unit = fileitem.getString();
                        System.out.println(recipe_ing3_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing4")) {
                        recipe_ing4 = fileitem.getString();
                        System.out.println(recipe_ing4);
                    } else if (fileitem.getFieldName().equals("recipe_ing4_qty")) {
                        recipe_ing4_qty = fileitem.getString();
                        System.out.println(recipe_ing4_qty);
                        if (!NumberCheck.isNumeric(recipe_ing4_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing4_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing4_unit")) {
                        recipe_ing4_unit = fileitem.getString();
                        System.out.println(recipe_ing4_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing5")) {
                        recipe_ing5 = fileitem.getString();
                        System.out.println(recipe_ing5);
                    } else if (fileitem.getFieldName().equals("recipe_ing5_qty")) {
                        recipe_ing5_qty = fileitem.getString();
                        System.out.println(recipe_ing5_qty);
                        if (!NumberCheck.isNumeric(recipe_ing5_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing5_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing5_unit")) {
                        recipe_ing5_unit = fileitem.getString();
                        System.out.println(recipe_ing5_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing6")) {
                        recipe_ing6 = fileitem.getString();
                        System.out.println(recipe_ing6);
                    } else if (fileitem.getFieldName().equals("recipe_ing6_qty")) {
                        recipe_ing6_qty = fileitem.getString();
                        System.out.println(recipe_ing6_qty);
                        if (!NumberCheck.isNumeric(recipe_ing6_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing6_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing6_unit")) {
                        recipe_ing6_unit = fileitem.getString();
                        System.out.println(recipe_ing6_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing7")) {
                        recipe_ing7 = fileitem.getString();
                        System.out.println(recipe_ing7);
                    } else if (fileitem.getFieldName().equals("recipe_ing7_qty")) {
                        recipe_ing7_qty = fileitem.getString();
                        System.out.println(recipe_ing7_qty);
                        if (!NumberCheck.isNumeric(recipe_ing7_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing7_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing7_unit")) {
                        recipe_ing7_unit = fileitem.getString();
                        System.out.println(recipe_ing7_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing8")) {
                        recipe_ing8 = fileitem.getString();
                        System.out.println(recipe_ing8);
                    } else if (fileitem.getFieldName().equals("recipe_ing8_qty")) {
                        recipe_ing8_qty = fileitem.getString();
                        System.out.println(recipe_ing8_qty);
                        if (!NumberCheck.isNumeric(recipe_ing8_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing8_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing8_unit")) {
                        recipe_ing8_unit = fileitem.getString();
                        System.out.println(recipe_ing8_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing9")) {
                        recipe_ing9 = fileitem.getString();
                        System.out.println(recipe_ing9);
                    } else if (fileitem.getFieldName().equals("recipe_ing9_qty")) {
                        recipe_ing9_qty = fileitem.getString();
                        System.out.println(recipe_ing9_qty);
                        if (!NumberCheck.isNumeric(recipe_ing9_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing9_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing9_unit")) {
                        recipe_ing9_unit = fileitem.getString();
                        System.out.println(recipe_ing9_unit);

                    } else if (fileitem.getFieldName().equals("recipe_ing10")) {
                        recipe_ing10 = fileitem.getString();
                        System.out.println(recipe_ing10);
                    } else if (fileitem.getFieldName().equals("recipe_ing10_qty")) {
                        recipe_ing10_qty = fileitem.getString();
                        System.out.println(recipe_ing10_qty);
                        if (!NumberCheck.isNumeric(recipe_ing10_qty)) {
                            System.out.println(NumberCheck.isNumeric(recipe_ing10_qty));
                            isNum = false;
                        }
                    } else if (fileitem.getFieldName().equals("recipe_ing10_unit")) {
                        recipe_ing10_unit = fileitem.getString();
                        System.out.println(recipe_ing10_unit);

                    }

                } else {
                    image_file = fileitem;

                }
            }

            if (isNum) {

                //Create hibernate session
                Session s = PoolManager.getSessionFactory().openSession();

                //Initiate transaction
                Transaction t = s.beginTransaction();

                Criteria c0 = s.createCriteria(Recipe.class);
                c0.add(Restrictions.eq("name", recipe_name));
                Recipe rec = (Recipe) c0.uniqueResult();

                if (rec == null) {

                    //Get cuisine category
                    CuisineCategory cc = (CuisineCategory) s.load(CuisineCategory.class, Integer.parseInt(recipe_cuisine));
                    //Get food category
                    FoodCategory fc = (FoodCategory) s.load(FoodCategory.class, Integer.parseInt(recipe_mealtype));
                    //Get health category
                    HealthCategory hc = (HealthCategory) s.load(HealthCategory.class, Integer.parseInt(recipe_healthcat));

                    //Create recipe object and save it
                    Recipe r = new Recipe();
                    r.setName(recipe_name);
                    r.setPreparingTime(recipe_preptime);
                    r.setServingQuantity(Integer.parseInt(recipe_qty));
                    r.setSkillLevel(recipe_skill);
                    r.setOverallRating(0.0);
                    r.setRatedCount(0);
                    r.setNotes("Notes");
                    r.setDirections(recipe_directions);

                    UserLogin ul = (UserLogin) request.getSession().getAttribute("user");

                    r.setUser(ul.getUser());
                    r.setFoodCategory(fc);
                    r.setCuisineCategory(cc);
                    r.setHealthCategory(hc);
                    r.setStatus("New");

                    s.save(r);

                    //Save image
                    String path = "images/recipe/" + recipe_name + ".jpg";

                    File savedFile = new File(getServletContext().getRealPath("/") + path);
                    image_file.write(savedFile);

                    System.out.println(request.getServletPath());
                    Image im = new Image();

                    //save image into database
                    File file = new File(getServletContext().getRealPath("/") + path);
                    byte[] bFile = new byte[(int) file.length()];

                    im.setImageData(bFile);
                    im.setPath(path);
                    im.setRecipe(r);

                    s.save(im);

                    //Save ingredient 1
                    Criteria c1 = s.createCriteria(Ingredient.class);
                    c1.add(Restrictions.eq("name", recipe_ing1));
                    Ingredient i1 = (Ingredient) c1.uniqueResult();

                    if (i1 == null & !recipe_ing1.equals("")) {
                        i1 = new Ingredient();
                        i1.setName(recipe_ing1.toLowerCase());
                        s.save(i1);
                    }

                    //save ingredient 2
                    Criteria c2 = s.createCriteria(Ingredient.class);
                    c2.add(Restrictions.eq("name", recipe_ing2));
                    Ingredient i2 = (Ingredient) c2.uniqueResult();

                    if (i2 == null & !recipe_ing2.equals("")) {
                        i2 = new Ingredient();
                        i2.setName(recipe_ing2.toLowerCase());
                        s.save(i2);
                    }

                    //save ingredient 3
                    Criteria c3 = s.createCriteria(Ingredient.class);
                    c3.add(Restrictions.eq("name", recipe_ing3));
                    Ingredient i3 = (Ingredient) c3.uniqueResult();

                    if (i3 == null && !recipe_ing3.equals("")) {
                        i3 = new Ingredient();
                        i3.setName(recipe_ing3.toLowerCase());
                        s.save(i3);
                    }

                    //Save ingredient 4
                    Criteria c4 = s.createCriteria(Ingredient.class);
                    c4.add(Restrictions.eq("name", recipe_ing4));
                    Ingredient i4 = (Ingredient) c4.uniqueResult();

                    if (i4 == null & !recipe_ing4.equals("")) {
                        i4 = new Ingredient();
                        i4.setName(recipe_ing4.toLowerCase());
                        s.save(i4);
                    }

                    //Save ingredient 5
                    Criteria c5 = s.createCriteria(Ingredient.class);
                    c5.add(Restrictions.eq("name", recipe_ing5));
                    Ingredient i5 = (Ingredient) c5.uniqueResult();

                    if (i5 == null & !recipe_ing5.equals("")) {
                        i5 = new Ingredient();
                        i5.setName(recipe_ing5.toLowerCase());
                        s.save(i5);
                    }

                    //save ingredient 6
                    Criteria c6 = s.createCriteria(Ingredient.class);
                    c6.add(Restrictions.eq("name", recipe_ing6));
                    Ingredient i6 = (Ingredient) c6.uniqueResult();

                    if (i6 == null & !recipe_ing6.equals("")) {
                        i6 = new Ingredient();
                        i6.setName(recipe_ing6.toLowerCase());
                        s.save(i6);
                    }

                    //save ingredient 7
                    Criteria c7 = s.createCriteria(Ingredient.class);
                    c7.add(Restrictions.eq("name", recipe_ing7));
                    Ingredient i7 = (Ingredient) c7.uniqueResult();

                    if (i7 == null & !recipe_ing7.equals("")) {
                        i7 = new Ingredient();
                        i7.setName(recipe_ing7.toLowerCase());
                        s.save(i7);
                    }

                    //save ingredient 8
                    Criteria c8 = s.createCriteria(Ingredient.class);
                    c8.add(Restrictions.eq("name", recipe_ing8));
                    Ingredient i8 = (Ingredient) c8.uniqueResult();

                    if (i8 == null & !recipe_ing8.equals("")) {
                        i8 = new Ingredient();
                        i8.setName(recipe_ing8.toLowerCase());
                        s.save(i8);
                    }

                    //save ingredient 9
                    Criteria c9 = s.createCriteria(Ingredient.class);
                    c9.add(Restrictions.eq("name", recipe_ing9));
                    Ingredient i9 = (Ingredient) c9.uniqueResult();

                    if (i9 == null & !recipe_ing9.equals("")) {
                        i9 = new Ingredient();
                        i9.setName(recipe_ing9.toLowerCase());
                        s.save(i9);
                    }

                    //save ingredient 10
                    Criteria c10 = s.createCriteria(Ingredient.class);
                    c10.add(Restrictions.eq("name", recipe_ing10));
                    Ingredient i10 = (Ingredient) c10.uniqueResult();

                    if (i10 == null & !recipe_ing10.equals("")) {
                        i10 = new Ingredient();
                        i10.setName(recipe_ing10.toLowerCase());
                        s.save(i10);
                    }

                    if (!recipe_ing1.equals("")) {
                        Unit u1 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing1_unit));

                        RecipeHasIngredient rhi1 = new RecipeHasIngredient();
                        rhi1.setIngredient(i1);
                        rhi1.setMainIngredient(Boolean.TRUE);
                        rhi1.setRecipe(r);
                        rhi1.setQuantity(Double.parseDouble(recipe_ing1_qty));
                        rhi1.setUnit(u1);
                        s.save(rhi1);
                    }

                    if (!recipe_ing2.equals("")) {
                        Unit u2 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing2_unit));

                        RecipeHasIngredient rhi2 = new RecipeHasIngredient();
                        rhi2.setIngredient(i2);
                        rhi2.setMainIngredient(Boolean.TRUE);
                        rhi2.setRecipe(r);
                        rhi2.setQuantity(Double.parseDouble(recipe_ing2_qty));
                        rhi2.setUnit(u2);
                        s.save(rhi2);
                    }

                    if (!recipe_ing3.equals("")) {
                        Unit u3 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing3_unit));

                        RecipeHasIngredient rhi3 = new RecipeHasIngredient();
                        rhi3.setIngredient(i3);
                        rhi3.setMainIngredient(Boolean.TRUE);
                        rhi3.setRecipe(r);
                        rhi3.setQuantity(Double.parseDouble(recipe_ing3_qty));
                        rhi3.setUnit(u3);
                        s.save(rhi3);
                    }

                    if (!recipe_ing4.equals("")) {
                        Unit u4 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing4_unit));

                        RecipeHasIngredient rhi4 = new RecipeHasIngredient();
                        rhi4.setIngredient(i4);
                        rhi4.setMainIngredient(Boolean.TRUE);
                        rhi4.setRecipe(r);
                        rhi4.setQuantity(Double.parseDouble(recipe_ing4_qty));
                        rhi4.setUnit(u4);
                        s.save(rhi4);
                    }

                    if (!recipe_ing5.equals("")) {
                        Unit u5 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing5_unit));

                        RecipeHasIngredient rhi5 = new RecipeHasIngredient();
                        rhi5.setIngredient(i5);
                        rhi5.setMainIngredient(Boolean.TRUE);
                        rhi5.setRecipe(r);
                        rhi5.setQuantity(Double.parseDouble(recipe_ing5_qty));
                        rhi5.setUnit(u5);
                        s.save(rhi5);
                    }

                    if (!recipe_ing6.equals("")) {
                        Unit u6 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing6_unit));

                        RecipeHasIngredient rhi6 = new RecipeHasIngredient();
                        rhi6.setIngredient(i6);
                        rhi6.setMainIngredient(Boolean.TRUE);
                        rhi6.setRecipe(r);
                        rhi6.setQuantity(Double.parseDouble(recipe_ing6_qty));
                        rhi6.setUnit(u6);
                        s.save(rhi6);
                    }

                    if (!recipe_ing7.equals("")) {
                        Unit u7 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing7_unit));

                        RecipeHasIngredient rhi7 = new RecipeHasIngredient();
                        rhi7.setIngredient(i7);
                        rhi7.setMainIngredient(Boolean.TRUE);
                        rhi7.setRecipe(r);
                        rhi7.setQuantity(Double.parseDouble(recipe_ing7_qty));
                        rhi7.setUnit(u7);
                        s.save(rhi7);
                    }

                    if (!recipe_ing8.equals("")) {
                        Unit u8 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing8_unit));

                        RecipeHasIngredient rhi8 = new RecipeHasIngredient();
                        rhi8.setIngredient(i8);
                        rhi8.setMainIngredient(Boolean.TRUE);
                        rhi8.setRecipe(r);
                        rhi8.setQuantity(Double.parseDouble(recipe_ing8_qty));
                        rhi8.setUnit(u8);
                        s.save(rhi8);
                    }

                    if (!recipe_ing9.equals("")) {
                        Unit u9 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing9_unit));

                        RecipeHasIngredient rhi9 = new RecipeHasIngredient();
                        rhi9.setIngredient(i9);
                        rhi9.setMainIngredient(Boolean.TRUE);
                        rhi9.setRecipe(r);
                        rhi9.setQuantity(Double.parseDouble(recipe_ing9_qty));
                        rhi9.setUnit(u9);
                        s.save(rhi9);
                    }

                    if (!recipe_ing10.equals("")) {
                        Unit u10 = (Unit) s.load(Unit.class, Integer.parseInt(recipe_ing10_unit));

                        RecipeHasIngredient rhi10 = new RecipeHasIngredient();
                        rhi10.setIngredient(i10);
                        rhi10.setMainIngredient(Boolean.TRUE);
                        rhi10.setRecipe(r);
                        rhi10.setQuantity(Double.parseDouble(recipe_ing10_qty));
                        rhi10.setUnit(u10);
                        s.save(rhi10);
                    }

                    t.commit();

                    msg = "success";

                } else {
                    msg = "exists";
                }
            } else {
                msg = "numex";
            }

            response.sendRedirect("user_post_new_recipe.jsp?msg=" + msg);

        } catch (Exception e) {
            throw new ServletException(e);
//            response.sendRedirect("add_new_recipe.jsp?msg=error");
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
