package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StaffMemberCrud {

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

        public static Boolean updateStaffById(String staffId,String attributeRequired,String changedValue)
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
                    staff.setStaffemail(changedValue);
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
}
