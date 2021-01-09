import com.AppointmentCrud;
import com.AppointmentEntity;
import com.OfficeHourCrud;
import com.OfficehourEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "DeleteSlots",value = "/DeleteSlots")
public class DeleteSlots extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       //TODO: send cancelDate
        Date cancelDate= null;
        try {
            cancelDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("cancelDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String staffId=request.getParameter("staffId");
        List<AppointmentEntity> appointments=new ArrayList<>();
        appointments= AppointmentCrud.selectAllAppointment("staffId",staffId);
        for(int i=0;i<appointments.size();i++)
        {
            Date date= OfficeHourCrud.findOfficeHour(appointments.get(i).getOfficeHourId()).getFromDate();
            if(date.equals(cancelDate) )
            {
            AppointmentCrud.removeAppointmentById(appointments.get(i).getAppointmentId());
            OfficeHourCrud.removeOfficeHourById(appointments.get(i).getOfficeHourId());
            }
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
