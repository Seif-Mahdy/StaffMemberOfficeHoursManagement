package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class OfficeHourCrud {

    public static OfficehourEntity findOfficeHour(int officeHourId) {
        OfficehourEntity officeHour = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            officeHour = session.find(OfficehourEntity.class,officeHourId );

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return officeHour;
    }

    public static boolean addOfficeHour(OfficehourEntity inputOfficeHour) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.save(inputOfficeHour);
            session.getTransaction().commit();
            session.close();
            isInsert = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public static boolean removeOfficeHourById(int officeHourId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();

            session.remove(session.get(OfficehourEntity.class, officeHourId));
            isDeleted = true;
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {

            e.printStackTrace();
        }

        return isDeleted;
    }

    public static Boolean updateOfficeHourById(int officeHourId,String attributeRequired,String changedValue)
    {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isUpdated = false;
        Session session = sessionObj.openSession();


        try {
            session.beginTransaction();
            OfficehourEntity officeHour = session.get(OfficehourEntity.class,officeHourId);


             if(attributeRequired.equals("From_Date"))
            {
                officeHour.setFromDate(Timestamp.valueOf(changedValue));
            }
            else if(attributeRequired.equals("To_Date"))
            {
                officeHour.setToDate(Timestamp.valueOf(changedValue));
            }
            else if(attributeRequired.equals("IsOffline"))
            {
                officeHour.setIsOffline(Byte.valueOf(changedValue));
            }
            else if(attributeRequired.equals("Location"))
            {
                officeHour.setLocation(changedValue);

            }
            isUpdated = true;
            session.getTransaction().commit();
            session.close();


        } catch (HibernateException e) {
            e.printStackTrace();

        }

        return isUpdated;
    }
    public static List<OfficehourEntity> selectAllOfficeHours() {
        List<OfficehourEntity>officeHours = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<OfficehourEntity> criteria = builder.createQuery(OfficehourEntity.class);
            Root<OfficehourEntity> root = criteria.from(OfficehourEntity.class);
            TypedQuery<OfficehourEntity> query = session.createQuery(criteria);
            officeHours = query.getResultList();


            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return officeHours;
    }
    public static List<OfficehourEntity> selectStaffOfficeHour(String staffId) {
        List<OfficehourEntity>officeHours = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<OfficehourEntity> criteria = builder.createQuery(OfficehourEntity.class);
            Root<OfficehourEntity> root = criteria.from(OfficehourEntity.class);
            criteria.where(builder.equal(root.get("StaffId"),staffId));
            TypedQuery<OfficehourEntity> query = session.createQuery(criteria);
            officeHours = query.getResultList();


            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return officeHours;
    }


}
