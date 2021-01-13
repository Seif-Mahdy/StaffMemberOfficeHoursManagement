package com;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


public class RegisterationMail {
    public static boolean sendMail(String receiverMail, String senderMail, String subject, String messageContent) {
        //change accordingly
        String from = "officeHoursMangmentSystem@gmail.com"; //change accordingly
        String host = "smtp.gmail.com";//or IP address
        String password = "Office1212";
        boolean isSent = false;
        //Get the session object
        messageContent = "This message is Sent by: " + senderMail + "\n" + messageContent;
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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail));
            message.setSubject(subject);
            message.setText(messageContent);

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
            isSent = true;

        } catch (MessagingException mex) {

            mex.printStackTrace();
        }
        return isSent;
    }

    public static Map<Key, List<MessageEntity>> retrieveMessages(String id) {
        List<MessageEntity> myChat = new ArrayList<>();
        List<String> receivers = new ArrayList<>();
        Map<String, String> att= new HashMap<>();
        Map<Key,List<MessageEntity>>myInbox = new HashMap<>();
        att.put("senderId",id);
        myChat = MessageCrud.findMessageByAtt(att);
        for (MessageEntity message :
                myChat) {
            if (!receivers.contains(message.getReceiverId())) {
                receivers.add(message.getReceiverId());

            }
        }
        att.remove("senderId");
        for ( String receiver:
             receivers) {
            att.put("senderId",id);
            att.put("receiverId",receiver);
        List<MessageEntity>senderMessages=MessageCrud.findMessageByAtt(att);
        att.put("senderId",receiver);
        att.put("receiverId",id);
        List<MessageEntity>receiverMessages=MessageCrud.findMessageByAtt(att);

       myInbox.put( new Key(id,receiver), mergeChat(senderMessages,receiverMessages));



        }
        return myInbox;


    }
    private static List<MessageEntity> mergeChat(List<MessageEntity>senderMessages,List<MessageEntity>receiverMessages)
    {
        List<MessageEntity> chat=new ArrayList<>();
        chat.addAll(senderMessages);
        chat.addAll(receiverMessages);
        Collections.sort(chat);
        return  chat;
    }
}
