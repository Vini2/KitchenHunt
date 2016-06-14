/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.Unit;
import HibFiles.User;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
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

        Criteria c = s.createCriteria(Recipe.class);
        c.add(Restrictions.eq("status", "New"));
        List<Recipe> r_list = c.list();

        for (Recipe recipe : r_list) {
            
        }

        Unit un = new Unit();
        
        
    }

}
