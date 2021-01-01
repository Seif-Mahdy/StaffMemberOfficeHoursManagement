package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CourseCrud {

        public static CourseEntity findCourse(int courseId) {
            CourseEntity course = null;
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();

            try  {
                Session session = sessionObj.openSession();
                session.beginTransaction();
                course = session.find(CourseEntity.class, courseId);

                session.getTransaction().commit();
                session.close();

            } catch (HibernateException e) {
                e.printStackTrace();
            }


            return course;
        }

        public static boolean addCourse(CourseEntity inputCourse) {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isInsert = false;

            try {
                Session session = sessionObj.openSession();
                session.beginTransaction();
                session.save(inputCourse);
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

        public static boolean removeCourseById(int courseId) {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isDeleted = false;

            try {
                Session session = sessionObj.openSession();
                session.beginTransaction();

                session.remove(session.get(CourseEntity.class, courseId));
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

        public static Boolean updateCourseById(String courseId,String attributeRequired,String changedValue)
        {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isUpdated = false;
            Session session = sessionObj.openSession();


            try {
                session.beginTransaction();
                CourseEntity course = session.get(CourseEntity.class,courseId);

                if(attributeRequired.equals("CourseName"))
                {
                  course.setCourseName(changedValue);
                    isUpdated = true;
                }


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



