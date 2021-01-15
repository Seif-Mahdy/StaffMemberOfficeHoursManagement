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

public class NotificationCrud {
    public static boolean addNotification(NotificationEntity inputMessage) {
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

    public static boolean removeNotificationById(int notificationId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();

            session.remove(session.find(NotificationEntity.class, notificationId));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
    public static List<NotificationEntity> findNotificationByAtt(Map<String, String> attributes) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        List<NotificationEntity> results = null;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<NotificationEntity> criteria = builder.createQuery(NotificationEntity.class);
            Root<NotificationEntity> root = criteria.from(NotificationEntity.class);
            for (Map.Entry<String, String> attribute : attributes.entrySet()) {

                criteria.select(root).where(builder.like(root.get(attribute.getKey()),attribute.getValue()));

            }


            TypedQuery<NotificationEntity> query = session.createQuery(criteria);
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

