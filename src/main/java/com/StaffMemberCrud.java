package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StaffMemberCrud {
    public static List<StaffmemberEntity> findStaffByAtt(String attribute, String attributeValue)
    {
        StaffmemberEntity staff = null;
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        List<StaffmemberEntity> results = null;

        try  {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<StaffmemberEntity> criteria = builder.createQuery(StaffmemberEntity.class);
            Root<StaffmemberEntity> root= criteria.from(StaffmemberEntity.class);
            criteria.select(root).where(builder.like(root.get(attribute),attributeValue));
            TypedQuery<StaffmemberEntity> query=session.createQuery(criteria);
            results = query.getResultList();




            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return results;

    }
        public static StaffmemberEntity findStaffMember(String stafftId) {
            StaffmemberEntity staff = null;
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();

            try  {
                Session session = sessionObj.openSession();
                session.beginTransaction();
                staff = session.find(StaffmemberEntity.class, stafftId);

                session.getTransaction().commit();
                session.close();

            } catch (HibernateException e) {
                e.printStackTrace();
            }


            return staff;
        }

        public static boolean addStaff(StaffmemberEntity inputStaff) {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isInsert = false;

            try {
                Session session = sessionObj.openSession();
                session.beginTransaction();
                session.save(inputStaff);
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

        public static boolean removeStaffById(String stafftId) {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isDeleted = false;

            try {
                Session session = sessionObj.openSession();
                session.beginTransaction();

                session.remove(session.get(StaffmemberEntity.class, stafftId));
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

        private static Boolean updateStaffById(String staffId,String attributeRequired,String changedValue)
        {
            SessionFactory sessionObj = HybernateUtil.getSessionFactory();
            boolean isUpdated = false;
            Session session = sessionObj.openSession();


            try {
                session.beginTransaction();
                StaffmemberEntity staff = session.get(StaffmemberEntity.class,staffId);

                if(attributeRequired.equals("StudentId"))
                {
                    staff.setStaffId(changedValue);
                }
                else if(attributeRequired.equals("StudentName"))
                {
                    staff.setStaffName(changedValue);
                }
                else if(attributeRequired.equals("StudentNumber"))
                {
                    staff.setStaffNumber(changedValue);
                }
                else if(attributeRequired.equals("StudentEmail"))
                {
                    staff.setStaffEmail(changedValue);
                }
                else if(attributeRequired.equals("StudentPassword"))
                {
                    staff.setStaffPassword(changedValue);
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
    public static boolean updateStaff(StaffmemberEntity updatedStaff)
    {
        SessionFactory sessionObj = HybernateUtil.getSessionFactory();
        boolean isInsert = false;

        try {
            Session session = sessionObj.openSession();
            session.beginTransaction();
            session.saveOrUpdate(updatedStaff);
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
}
