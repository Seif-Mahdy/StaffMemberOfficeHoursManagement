package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;

public class CourseToStaffCrud {
    public static CoursetostaffEntity find(int courseId,String staffId) {
        CoursetostaffEntity recored = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("courseId",courseId);
            parameters.put("staffId",staffId);


            recored = session.find(CoursetostaffEntity.class,parameters);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return recored;
    }

    public static boolean add(CoursetostaffEntity recored) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.save(recored);
            session.getTransaction().commit();
            session.close();
            isInsert = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public static boolean remove(int courseId,String staffId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("courseId",courseId);
            parameters.put("staffId",staffId);

            session.remove(session.find(CoursetostaffEntity.class, parameters));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }



}


