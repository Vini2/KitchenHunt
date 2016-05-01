/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.Image;
import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.RecipeHasIngredient;
import HibFiles.UserLogin;
import java.util.Iterator;
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
        Recipe r = (Recipe) s.load(Recipe.class, 6);

        

        Set ss = r.getRecipeHasIngredients();

        for (Object arg : ss) {

            RecipeHasIngredient i = (RecipeHasIngredient) arg;

            System.out.println(i.getIngredient().getName() + i.getQuantity());

        }

    }

}
