/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.Comment;
import HibFiles.Image;
import HibFiles.Ingredient;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.RecipeHasIngredient;
import HibFiles.User;
import HibFiles.UserLogin;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class test {

    public static void main(String[] args) {

         User u = new User();
                 
        Session s = PoolManager.getSessionFactory().openSession();
     
        Criteria c = s.createCriteria(Recipe.class);
        c.add(Restrictions.eq("user", u));
        List<Recipe> r_list = c.list();
        
        for (Recipe r : r_list) {
            
            
            
        }
        
        
        
//        for (Comment comment : comment_list) {
//            
//        }
//
//        Set<RecipeHasIngredient> ss = r.getRecipeHasIngredients();
//        for (RecipeHasIngredient i : ss) {
//
//            Double d = i.getQuantity();
//            int q = d.intValue();
//            
//            System.out.println(i.getUnit().getName()+ i.getIngredient().getName());
//            
//        }

    }

}
