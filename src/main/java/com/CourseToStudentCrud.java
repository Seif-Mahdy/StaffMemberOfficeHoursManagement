package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;

public class CourseToStudentCrud {
    public static CoursetostudentsEntity find(int courseId,String studentId) {
        CoursetostudentsEntity recored = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("courseId",courseId);
            parameters.put("staffId",studentId);


            recored = session.find( CoursetostudentsEntity.class,parameters);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return recored;
    }

    public static boolean add( CoursetostudentsEntity recored) {
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
        }finally {
            sessionObj.close();
        }
        return isInsert;
    }

    public static boolean remove(int courseId,String studentId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("courseId",courseId);
            parameters.put("staffId",studentId);

            session.remove(session.find( CoursetostudentsEntity.class, parameters));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            sessionObj.close();
        }

        return isDeleted;
    }



}
