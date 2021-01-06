import com.StaffMemberCrud;
import com.StaffmemberEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", value = "/Test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        System.out.println(id);
        try {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(id);
            ObjectMapper mapper = new ObjectMapper();
            String staffJSON = mapper.writeValueAsString(staff);
//            System.out.println(staffJSON);
            PrintWriter out = response.getWriter();
            out.print(staffJSON);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
