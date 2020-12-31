import com.StaffMemberCrud;
import com.StaffmemberEntity;
import com.StudentCrud;
import com.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("login-type");
        if (type.equals("student")) {

            StudentEntity student = StudentCrud.findStudent(request.getParameter("id"));
            if (student != null) {
                System.out.println("hello student");
            } else {
                System.out.println("you are not welcome student");
            }
        } else if (type.equals("staff")) {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(request.getParameter("id"));
            if (staff != null) {
                System.out.println("hello staff");
            } else {
                System.out.println("you are not welcome staff");
            }
        }
    }
}


