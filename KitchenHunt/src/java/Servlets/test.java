/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.PoolManager;
import HibFiles.User;
import HibFiles.UserLogin;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class test {

    public static void main(String[] args) {

        Session s = PoolManager.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Criteria c = s.createCriteria(User.class);
        List<User> u_list = c.list();

        for (User user : u_list) {

            
            Set<UserLogin> user_set = user.getUserLogins();
            Iterator iter = user_set.iterator();
            UserLogin user_ul = (UserLogin) iter.next();
            
        }

    }

}
