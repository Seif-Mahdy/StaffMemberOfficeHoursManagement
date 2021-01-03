package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentCrud {
    //TODO:implement find student by email and by phone number
    public static StudentEntity findStudent(String studentId) {
        StudentEntity student = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            student = session.find(StudentEntity.class, studentId);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            System.out.println(e);
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
            System.out.println(e);
            e.printStackTrace();
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
        }

        return isDeleted;
    }

    public static Boolean updateStudentById(String studentId, String attributeRequired, String changedValue) {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isUpdated = false;
        Session session = sessionObj.openSession();


        try {
            session.beginTransaction();
            StudentEntity student = session.get(StudentEntity.class, studentId);

            switch (attributeRequired) {
                case "StudentId":
                    student.setStudentId(changedValue);
                    break;
                case "StudentName":
                    student.setStudentName(changedValue);
                    break;
                case "StudentNumber":
                    student.setStudentNumber(changedValue);
                    break;
                case "StudentEmail":
                    student.setStudentEmail(changedValue);
                    break;
                case "StudentPassword":
                    student.setStudentPassword(changedValue);
                    break;
            }
            isUpdated = true;
            session.getTransaction().commit();
            session.close();


        } catch (HibernateException e) {
            e.printStackTrace();

        }

        return isUpdated;
    }

}

