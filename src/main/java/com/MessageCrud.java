package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public class MessageCrud {
    public static MessageEntity findMessage(int messageId) {
        MessageEntity message = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            message = session.find(MessageEntity.class, messageId);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return message;
    }

    public static boolean addMessage(MessageEntity inputMessage) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.save(inputMessage);
            session.getTransaction().commit();
            session.close();
            isInsert = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public static boolean removeMessageById(int messageId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();

            session.remove(session.find(MessageEntity.class, messageId));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    public static Boolean updateMessageById(int messageId, String attributeRequired, String changedValue) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isUpdated = false;
        Session session = sessionObj.openSession();


        try {
            session.beginTransaction();
            MessageEntity message = session.find(MessageEntity.class, messageId);

            if (attributeRequired.equals("MessageContent")) {
                message.setMessageContent(changedValue);
                isUpdated = true;
            }


            session.getTransaction().commit();
            session.close();


        } catch (HibernateException e) {
            e.printStackTrace();

        }

        return isUpdated;
    }

    public static List<MessageEntity> findMessageByAtt(Map<String, String> attributes) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        List<MessageEntity> results = null;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<MessageEntity> criteria = builder.createQuery(MessageEntity.class);
            Root<MessageEntity> root = criteria.from(MessageEntity.class);
            for (Map.Entry<String, String> attribute : attributes.entrySet()) {

                criteria.select(root).where(builder.like(root.get(attribute.getKey()),attribute.getValue()));

            }


        TypedQuery<MessageEntity> query = session.createQuery(criteria);
        results = query.getResultList();


        session.getTransaction().commit();
        session.close();

    } catch(
    HibernateException e)

    {
        e.printStackTrace();
    }


        return results;

}
}
