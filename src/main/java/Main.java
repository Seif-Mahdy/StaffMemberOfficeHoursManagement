import com.*;
import org.hibernate.Hibernate;

import org.hibernate.SessionFactory;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.activation.*;


public class Main {
    public static void main(final String[] args) throws Exception {


      /*  StudentEntity student = new StudentEntity();
        student.setStudentName("Abdelrhman hosny awad");
        student.setStudentId("20170144");
        student.setStudentPassword("A01018236359");
        student.setStudentEmail("body.hosny111@gmail.com");
        student.setStudentNumber("01148258062");
        System.out.println(StudentCrud.updateStudent(student));

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
        System.out.println( CourseToStaffCrud.add(recored));


     List<StudentEntity> student;
    student=StudentCrud.finStudentByAtt("studentEmail","body.hosny111@gmail.com");
        System.out.println(student.get(0).getStudentId());*/
        String to = "seifalaa143@gmail.com";//change accordingly
        String from = "officeHoursMangmentSystem@gmail.com"; //change accordingly
        String host = "smtp.gmail.com";//or IP address

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("officeHoursMangmentSystem@gmail.com", "Office1212");
            }
        });

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


}


