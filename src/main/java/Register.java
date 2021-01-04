import com.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/Register", value = "/Register")
public class Register extends HttpServlet {
    //TODO:captcha validation
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String registerType = request.getParameter("registerType");
        String captchaToken = request.getParameter("recaptchaResponse");

        //System.out.println("captchaToken " + captchaToken);
        //TODO:add phone number and email validation
        if (!registerType.equals("null")) {

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
                    request.getSession().setAttribute("success", "Account created successfully!");
                    RegisterationMail.sendMail(email);
                    out.print("success");
                }
            } else {
                out.print("There is already an account associated with these credentials!");
            }
        } else {

            StudentEntity student = StudentCrud.findStudent(userID);
            if (student == null) {
                student = new StudentEntity();
                student.setStudentId(userID);
                student.setStudentEmail(email);
                student.setStudentName(userName);
                student.setStudentNumber(phoneNumber);
                student.setStudentPassword("123456789");
                boolean done = StudentCrud.addStudent(student);
                System.out.println("3aaaaa");
                if (done) {
                    request.getSession().setAttribute("success", "Account created successfully!");
                    //TODO:solve this exception javax.mail.MessagingException in the next line

                    boolean isSent = RegisterationMail.sendMail(email);
                    System.out.println(isSent);
                    out.print("success");
                }
            } else {
                out.print("There is already an account associated with these credentials!");
            }
        }
    }


}
