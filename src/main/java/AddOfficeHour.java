import com.OfficeHourCrud;
import com.OfficehourEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet(name = "AddOfficeHour",value="/AddOfficeHour")
public class AddOfficeHour extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        //TODO: duplicate office hour(change from_date and to_date to be unique)
    String date=request.getParameter("date");
    String fromTime = request.getParameter("fromTime");
    String toTime=request.getParameter("toTime");
    Byte isOffline= Byte.valueOf(request.getParameter("isOffline"));
    String location=request.getParameter("location");
    String from=date+" "+fromTime+":00";
    Timestamp fromDate=Timestamp.valueOf(from);
    String to=date+" "+toTime+":00";
    Timestamp toDate=Timestamp.valueOf(to);
    OfficehourEntity slot=new OfficehourEntity();
    slot.setStaffId(request.getSession().getAttribute("id").toString());
    slot.setToDate(toDate);
    slot.setFromDate(fromDate);
    slot.setIsOffline(isOffline);
    slot.setLocation(location);
       if( OfficeHourCrud.addOfficeHour(slot))
       {
           out.print("success");
       }
       else
       {
           out.print("failed to add slot");
       }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
