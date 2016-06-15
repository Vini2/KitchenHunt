/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.FoodCategory;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.User;
import HibFiles.UserLogin;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class test {

    public static void main(String[] args) {

        Session s = PoolManager.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Criteria c0 = s.createCriteria(Recipe.class);
        List<Recipe> recipe_list = c0.list();

        Criteria cfc = s.createCriteria(FoodCategory.class);
        List<FoodCategory> fc_list = cfc.list();

        for (FoodCategory fc : fc_list) {

            Criteria cr1 = s.createCriteria(Recipe.class);
            cr1.add(Restrictions.eq("foodCategory", fc));
            List<Recipe> cr1_list = cr1.list();
            
            int perc = cr1_list.size()/recipe_list.size()*100;

        }

    }

}
