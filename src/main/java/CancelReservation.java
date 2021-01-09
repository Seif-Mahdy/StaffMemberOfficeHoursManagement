import com.AppointmentCrud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CancelReservation",value = "/CancelReservation")
public class CancelReservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int appointmentId=Integer.parseInt(request.getParameter("appointmentId"));
        PrintWriter out =response.getWriter();
       if(AppointmentCrud.removeAppointmentById(appointmentId))
       {
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
