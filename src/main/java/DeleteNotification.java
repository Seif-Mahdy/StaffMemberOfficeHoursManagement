import com.NotificationCrud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteNotification",value = "/DeleteNotification")
public class DeleteNotification extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int notificationId=Integer.parseInt(request.getParameter("notificationId"));
        PrintWriter out=response.getWriter();
        System.out.println(notificationId+"iddd");
      if(NotificationCrud.removeNotificationById(notificationId))
      {
          System.out.println("success");
          out.print("success");
      }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
