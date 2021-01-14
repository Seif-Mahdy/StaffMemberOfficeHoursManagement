import com.AppointmentCrud;
import com.AppointmentEntity;
import com.OfficeHourCrud;
import com.OfficehourEntity;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DeleteSlots", value = "/DeleteSlots")
public class DeleteSlots extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isDeleted = true;
        PrintWriter out = response.getWriter();
        String inputDate = request.getParameter("date");
        inputDate = inputDate + " " + "00:00:00";
        DateTime cancelDate = new DateTime(Timestamp.valueOf(inputDate));
        String staffId = request.getSession().getAttribute("id").toString();
        List<AppointmentEntity> appointments = new ArrayList<>();
        appointments = AppointmentCrud.selectAllAppointment("staffId", staffId);
        for (int i = 0; i < appointments.size(); i++) {
            Date date = OfficeHourCrud.findOfficeHour(appointments.get(i).getOfficeHourId()).getFromDate();
            DateTime dateTime = new DateTime(date);
            org.joda.time.LocalDate local1 = cancelDate.toLocalDate();
            LocalDate local2 = dateTime.toLocalDate();

            if (local1.compareTo(local2) == 0) {
                AppointmentEntity appointment = AppointmentCrud.findAppointment(appointments.get(i).getAppointmentId());
                appointment.setIsCanceled((byte) 1);
                if (!(AppointmentCrud.updateAppointment(appointment) && OfficeHourCrud.removeOfficeHourById(appointments.get(i).getOfficeHourId()))) {
                    isDeleted = false;
                }


            }
        }
        if (isDeleted && appointments.size()>0) {
            out.print("success");
        } else {
            out.print("failed to delete");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
