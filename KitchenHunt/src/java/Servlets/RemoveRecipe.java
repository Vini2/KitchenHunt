/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibFiles.PoolManager;
import HibFiles.Recipe;
import HibFiles.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class RemoveRecipe extends HttpServlet {

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

            Session s = PoolManager.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();

            Recipe r = (Recipe) s.load(Recipe.class, Integer.parseInt(request.getParameter("rid")));

            s.delete(r);

            t.commit();

            Set<UserLogin> user_set = r.getUser().getUserLogins();
            Iterator iter = user_set.iterator();
            UserLogin user_ul = (UserLogin) iter.next();

            //Send Notification Email
            text = "Hi " + r.getUser().getFname() + ",<br><br>We are very sorry to let you know that the recipe you posted "
                    +r.getName()+" has been removed because it does not meet Kitchen Hunt standards.<br><br>"
                    + "We are very sorry about any inconvenience caused.<br><br>"
                    + "Thank you.<br><br>"
                    + "Regards,<br>Kitchen Hunt";
            System.out.println(text);
            System.out.println("Sending Notification email");
            to = user_ul.getEmail();
            sendMail();
            System.out.println("Notification email sent");

            response.sendRedirect("admin_publish_recipe.jsp");

        } catch (Exception e) {
            throw new ServletException();
        }
    }

    private static class MailAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(sender_email, password);
        }
    }
    static String sender_email = "kitchenhunt.com@gmail.com";
    static String password = "kitchenhunt@123";
    static String host = "smtp.gmail.com";
    static String port = "587";
    static String to = "";
    static String subject = "Recipe Removed";
    static String text = "";

    public static void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.user", sender_email);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        try {
            Authenticator auth = new MailAuthenticator();
            // Get the default Session object.
            javax.mail.Session session = javax.mail.Session.getInstance(props, auth);

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(sender_email));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Send the actual HTML message
            message.setContent(text, "text/html");

            // Send message
            Transport.send(message);

        } catch (Exception mex) {
            mex.printStackTrace();
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
