package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

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
        }finally {
            sessionObj.close();
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
        }finally {
            sessionObj.close();
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
                officeHour.setFromDate(Date.valueOf(changedValue));
            }
            else if(attributeRequired.equals("To_Date"))
            {
                officeHour.setToDate(Date.valueOf(changedValue));
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

        }finally {
            sessionObj.close();
        }

        return isUpdated;
    }

}
