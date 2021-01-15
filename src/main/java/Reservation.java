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

@WebServlet(name = "Reservation",value ="/Reservation" )
public class Reservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");

        int slotId = Integer.parseInt(request.getParameter("slotId"));
        String staffId = request.getParameter("staffId");
        PrintWriter out = response.getWriter();
        NotificationEntity notification=new NotificationEntity();
        OfficehourEntity slot=OfficeHourCrud.findOfficeHour(slotId);
        StudentEntity student=StudentCrud.findStudent(studentId);
        StaffmemberEntity staff=StaffMemberCrud.findStaffMember(staffId);

        if (reserveApp(slotId, studentId, staffId)) {
            Date date=new Date();
            String notificationContent="You have an appointment with "+student.getStudentName()+" his ID is "+student.getStudentId()+" At "+slot.getFromDate() +"";
            notification.setUserId(staffId);
            notification.setNotificationContent(notificationContent);
            notification.setNotificationDate(new Timestamp(date.getTime()));
            notification.setNotificationSubject("Appointment Reservation");
            NotificationCrud.addNotification(notification);
            RegisterationMail.sendMail(staff.getStaffEmail(),null,"Appointment Reservation",notificationContent);
            notification.setUserId(studentId);
            notificationContent="You have an appointment with "+staff.getStaffRole()+" : "+staff.getStaffName()+ "At " +slot.getFromDate() +"";
            notification.setNotificationContent(notificationContent);
            NotificationCrud.addNotification(notification);
            out.print("success");
        } else {
            out.print("Reservation failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean reserveApp(int slotId, String studentId, String staffId) {
        boolean isInsert = false;
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setOfficeHourId(slotId);
        appointment.setStaffId(staffId);
        appointment.setStudentId(studentId);
        isInsert = AppointmentCrud.addAppointment(appointment);
        return isInsert;
    }
}
