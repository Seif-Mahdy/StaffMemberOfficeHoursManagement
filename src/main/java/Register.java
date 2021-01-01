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
import java.io.PrintWriter;

@WebServlet(name = "/Register", value = "/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String registerType = request.getParameter("registerType");

        System.out.println("registerType: " + registerType);

        if (registerType != null) {
            System.out.println("staff");
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(userID);
            if (staff == null) {
                staff = new StaffmemberEntity();
                staff.setStaffId(userID);
                staff.setStaffEmail(email);
                staff.setStaffName(userName);
                staff.setStaffNumber(phoneNumber);
                staff.setStaffPassword("123456789");
                staff.setStaffRole(registerType);
                boolean done = StaffMemberCrud.addStaff(staff);
                if (done) {
                    response.sendRedirect("index.jsp");
                }
            } else {
                out.print("There is already an account associated with these credentials!");
            }
        } else {
            System.out.println("student");
            StudentEntity student = StudentCrud.findStudent(userID);
            if (student == null) {
                student = new StudentEntity();
                student.setStudentId(userID);
                student.setStudentEmail(email);
                student.setStudentName(userName);
                student.setStudentNumber(phoneNumber);
                student.setStudentPassword("123456789");
                boolean done = StudentCrud.addStudent(student);
                if (done) {
                    out.print("success");
                }
            } else {
                out.print("There is already an account associated with these credentials!");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
