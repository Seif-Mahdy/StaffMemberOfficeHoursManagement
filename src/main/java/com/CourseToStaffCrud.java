package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static List<String> selectAllStaffForCourse(int course) {
        List<CoursetostaffEntity>staffs = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        List<String>staffIds = new ArrayList<>();


        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<CoursetostaffEntity> criteria = builder.createQuery(CoursetostaffEntity.class);
            Root<CoursetostaffEntity> root = criteria.from(CoursetostaffEntity.class);
         //   criteria.select(root.get("staffId"));
            criteria.where(builder.equal(root.get("courseId"),course));
            TypedQuery<CoursetostaffEntity> query = session.createQuery(criteria);
            staffs = query.getResultList();
            for (CoursetostaffEntity staff : staffs) {


                if (staff.getStaffId() != null) {
                    staffIds.add(staff.getStaffId());
                }
            }

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return staffIds;
    }

}


