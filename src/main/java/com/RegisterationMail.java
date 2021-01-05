package com;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class RegisterationMail {
    public static boolean sendMail(String mail) {
        //change accordingly
        String from = "officeHoursMangmentSystem@gmail.com"; //change accordingly
        String host = "smtp.gmail.com";//or IP address
        String password = "Office1212";
        boolean isSent = false;
        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            message.setSubject("Registration Temporary password");
            message.setText("Hello, this is your Account Temporary password (123456789) <\n> we advice you to change it  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
            isSent = true;

        } catch (MessagingException mex) {

            mex.printStackTrace();
        }
        return isSent;
    }
}
