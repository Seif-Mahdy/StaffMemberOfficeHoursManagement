import com.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {

       /*
        StudentEntity student = new StudentEntity();
        student.setStudentName("Abdelrhman hosny awad");
        student.setStudentId("20170144");
        student.setStudentPassword("A01018236359");
        student.setStudentEmail("body.hosny111@gmail.com");
        student.setStudentNumber("01018236359");
        System.out.println(StudentCrud.addStudent(student));

        StudentEntity student2 ;
        student2=StudentCrud.findStudent("20170144");
        System.out.println(student2.getStudentName());
        StudentCrud.updateStudentById("20170144","StudentNumber","01018236358");
        System.out.println(student2.getStudentNumber());

        StaffmemberEntity staff= new StaffmemberEntity();
        staff.setStaffId("20170000");
        staff.setStaffemail("hello.com");
        staff.setStaffName("elramly");
        staff.setStaffNumber("0101010");
        staff.setStaffRole((byte) 1);
        staff.setStaffPassword("1111");
        System.out.println(StaffMemberCrud.addStaff(staff));

        CourseEntity course= new CourseEntity();
        course.setCourseName("Cs");
        CourseCrud.addCourse(course);*/
        /*CoursetostaffEntity recored = new CoursetostaffEntity();
        recored.setCourseId(1);
        recored.setStaffId("20170000");
        System.out.println( CourseToStaffCrud.add(recored));*/


     List<StudentEntity> student;
    student=StudentCrud.finStudentByAtt("studentEmail","body.hosny111@gmail.com");
        System.out.println(student.get(0).getStudentId());





    }

}
