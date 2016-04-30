<%-- 
    Document   : newjsp
    Created on : Apr 30, 2016, 9:49:38 PM
    Author     : User
--%>

<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%
    String result;
    // Recipient's email ID needs to be mentioned.
    String to = "viji.mallawaarachchi@gmail.com";

    // Sender's email ID needs to be mentioned
    String from = "kitchenhunt.com@gmail.com";

    // Assuming you are sending email from localhost
    String host = "smtp.gmail.com";  //yahoo - smtp.mail.yahoo.com, live - smtp.live.com
    String port = "465";

    // Get system properties object
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);

    // Get the default Session object.
    Session mailSession = Session.getDefaultInstance(props);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(mailSession);
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));
        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // Set Subject: header field
        message.setSubject("This is the Subject Line!");
        // Now set the actual message
        message.setText("This is actual message");
        // Send message
        Transport.send(message);
        result = "Sent message successfully....";
    } catch (MessagingException mex) {
        mex.printStackTrace();
        result = "Error: unable to send message....";
    }
%>
<html>
    <head>
        <title>Send Email using JSP</title>
    </head>
    <body>
    <center>
        <h1>Send Email using JSP - :)</h1>
    </center>
    <p align="center">
        <%
            out.println("Result: " + result + "\n");
        %>
    </p>
</body>
</html>