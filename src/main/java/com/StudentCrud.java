package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentCrud {
    public static StudentEntity findStudent(String studentId) {
        StudentEntity student = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            student = session.find(StudentEntity.class, studentId);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return student;
    }

    public static boolean addStudent(StudentEntity inputStudent) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.save(inputStudent);
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

    public static boolean removeStudentById(String studentId) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isDeleted = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();

            session.remove(session.get(StudentEntity.class, studentId));
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

    public static Boolean updateStudentById(String studentId,String attributeRequired,String changedValue)
    {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isUpdated = false;
        Session session = sessionObj.openSession();


        try {
            session.beginTransaction();
        StudentEntity student = session.get(StudentEntity.class,studentId);

            if(attributeRequired.equals("StudentId"))
        {
            student.setStudentId(changedValue);
        }
        else if(attributeRequired.equals("StudentName"))
        {
            student.setStudentName(changedValue);
        }
        else if(attributeRequired.equals("StudentNumber"))
        {
            student.setStudentNumber(changedValue);
        }
        else if(attributeRequired.equals("StudentEmail"))
        {
            student.setStudentEmail(changedValue);
        }
        else if(attributeRequired.equals("StudentPassword"))
        {
            student.setStudentPassword(changedValue);
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

