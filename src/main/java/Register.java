import com.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        if (!registerType.equals("null")) {

            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(userID);
            List<StaffmemberEntity> staffByEmail=StaffMemberCrud.findStaffByAtt("staffEmail",email);
            List<StaffmemberEntity> staffByNumber=StaffMemberCrud.findStaffByAtt("staffNumber",phoneNumber);
            if (staff == null && staffByEmail.size()==0 && staffByNumber.size()==0) {
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
            List<StudentEntity> studentByEmail=StudentCrud.findStudentByAtt("studentEmail",email);
            List<StudentEntity> studentByNumber = StudentCrud.findStudentByAtt("studentNumber",phoneNumber);
            if (student == null && studentByNumber.size()==0 && studentByEmail.size()==0) {
                student = new StudentEntity();
                student.setStudentId(userID);
                student.setStudentEmail(email);
                student.setStudentName(userName);
                student.setStudentNumber(phoneNumber);
                student.setStudentPassword("123456789");
                boolean isSent =RegisterationMail.sendMail(email);


                if (isSent) {
                    request.getSession().setAttribute("success", "Account created successfully!");

                    boolean isAdded = StudentCrud.addStudent(student);
                    if(isAdded) {
                        out.print("success");
                    }
                }
            } else {
                out.print("There is already an account associated with these credentials!");
            }
        }
    }


}
