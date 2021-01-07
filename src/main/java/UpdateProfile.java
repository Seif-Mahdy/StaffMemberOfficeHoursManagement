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
import java.util.List;

@WebServlet(name = "UpdateProfile", value = "/UpdateProfile")
public class UpdateProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String loginType = request.getSession().getAttribute("loginType").toString();
        String userId = request.getSession().getAttribute("id").toString();

        //System.out.println(username + " " + password + " " + phoneNumber + " " + email + " " + loginType + " " + userId);

        if (loginType.equals("student")) {
            //if email changed , check if there is exist another account with this mail
            StudentEntity student = StudentCrud.findStudent(userId);
            if (!student.getStudentEmail().equals(email)) {
                List<StudentEntity> students = StudentCrud.findStudentByAtt("studentEmail", email);
                if (students.size() > 0) {
                    // out.print("email is exist");
                    out.print("This mail has been taken!");
                } else {

                    student.setStudentEmail(email);
                }

            }
            if (!student.getStudentNumber().equals(phoneNumber)) {
                List<StudentEntity> students = StudentCrud.findStudentByAtt("studentNumber", phoneNumber);
                if (students.size() > 0) {
                    out.print("This number has been taken!");

                } else {
                    student.setStudentNumber(phoneNumber);
                }
            }
            student.setStudentPassword(password);
            student.setStudentName(username);
            StudentCrud.updateStudent(student);
            request.getSession().setAttribute("profileUpdate","Profile updated successfully!");
            out.print("success");

        } else if (loginType.equals("staff")) {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(userId);
            if (!staff.getStaffEmail().equals(email)) {
                List<StaffmemberEntity> staffs = StaffMemberCrud.findStaffByAtt("staffemail", email);
                if (staffs.size() > 0) {
                    // out.print("email is exist");
                    out.print("This mail has been taken!");
                } else {
                    staff.setStaffEmail(email);

                }
                if (!staff.getStaffNumber().equals(phoneNumber)) {
                    List<StaffmemberEntity> staffMembers = StaffMemberCrud.findStaffByAtt("staffNumber", phoneNumber);
                    if (staffMembers.size() > 0) {
                        out.print("This number has been taken!");
                    } else {
                        staff.setStaffNumber(phoneNumber);
                    }
                }

            }
            staff.setStaffPassword(password);
            staff.setStaffName(username);
            staff.setStaffNumber(phoneNumber);
            StaffMemberCrud.updateStaff(staff);
            request.getSession().setAttribute("profileUpdate","Profile updated successfully!");
            out.print("success");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
