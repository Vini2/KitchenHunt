/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.Comment;
import HibFiles.Image;
import HibFiles.Ingredient;
import HibFiles.MyIngredient;
import HibFiles.MyKitchen;
import HibFiles.Notification;
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

        Session s = PoolManager.getSessionFactory().openSession();
        MyIngredient i = new MyIngredient();
        
        
        
        
        Criteria c1 = s.createCriteria(User.class);
        c1.add(Restrictions.eq("fname", "Sanduni Prasadi"));
        User u = (User) c1.uniqueResult();
        
//        Criteria c = s.createCriteria(MyIngredient.class);
//        c.add(Restrictions.eq("user", u));
//        List<MyIngredient> mi_list = c.list();
//        
//        for (MyIngredient mi : mi_list) {
//            
//        }

        
        
//        Criteria c = s.createCriteria(MyKitchen.class);
//        c.add(Restrictions.eq("user", u));
//        List<MyKitchen> n_list = c.list();
//        
//        int len = n_list.size();
//
//        for (MyKitchen not : n_list) {
//            System.out.println(not.getRecipe().getName());
//        }

        Criteria c = s.createCriteria(Notification.class);
        c.add(Restrictions.eq("user", u));
        c.add(Restrictions.eq("status", "Unread"));
        List<Notification> n_list = c.list();
        
        int len = n_list.size();
        
        for (Notification not : n_list) {
            
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
