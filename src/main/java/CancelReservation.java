import com.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "CancelReservation",value = "/CancelReservation")
public class CancelReservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int appointmentId=Integer.parseInt(request.getParameter("appointmentId"));
     AppointmentEntity appointment = AppointmentCrud.findAppointment(appointmentId);
     StudentEntity student=StudentCrud.findStudent(appointment.getStudentId());
     StaffmemberEntity staff=StaffMemberCrud.findStaffMember(appointment.getStaffId());
     OfficehourEntity slot= OfficeHourCrud.findOfficeHour(appointment.getOfficeHourId());


        PrintWriter out =response.getWriter();
       if(AppointmentCrud.removeAppointmentById(appointmentId))
       {
           NotificationEntity notification = new NotificationEntity();
           Date date = new Date();
           // create notification for student
            String notificationContent="Your Appointment with "+staff.getStaffId() +" At "+ slot.getFromDate()+" is Canceled";
            notification.setUserId(student.getStudentId());
            notification.setNotificationContent(notificationContent);
            notification.setNotificationDate(new Timestamp(date.getTime()));
            notification.setNotificationSubject("Appointment Cancellation");
           NotificationCrud.addNotification(notification);
           RegisterationMail.sendMail(student.getStudentEmail(),null,"Appointment Canceled",notificationContent);
          //Create notification for staff
            notification.setUserId(staff.getStaffId());
            notification.setNotificationContent(notificationContent);
            notificationContent="Your Appointment with "+student.getStudentId() +" At "+ slot.getFromDate()+" is Canceled";
            NotificationCrud.addNotification(notification);
           RegisterationMail.sendMail(staff.getStaffEmail(),null,"Appointment Cancellation",notificationContent);


//TODO:lock cancel button
           out.print("success");
       }
       else
       {
           out.print("failed to cancel appointment");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
