package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AppointmentCrud {
    public static AppointmentEntity findAppointment(int appointmentId) {
        AppointmentEntity appointment = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            appointment = session.find(AppointmentEntity.class, appointmentId);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return appointment;
    }

    public static boolean addAppointment(AppointmentEntity inputAppointment) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.save(inputAppointment);
            session.getTransaction().commit();
            session.close();
            isInsert = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public static boolean removeAppointmentById(int appointmentId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();

            session.remove(session.get(AppointmentEntity.class, appointmentId));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
    public static List<AppointmentEntity> selectAllAppointment(String attribute,String id) {
        List<AppointmentEntity>appointments= null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();



        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<AppointmentEntity> criteria = builder.createQuery(AppointmentEntity.class);
            Root<AppointmentEntity> root = criteria.from(AppointmentEntity.class);
            //   criteria.select(root.get("staffId"));
            criteria.where(builder.equal(root.get(attribute),id));
            TypedQuery<AppointmentEntity> query = session.createQuery(criteria);
            appointments = query.getResultList();


            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return appointments;
    }
    public static boolean updateAppointment(AppointmentEntity updatedApp) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.saveOrUpdate(updatedApp);
            session.getTransaction().commit();
            session.close();
            isInsert = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

}
