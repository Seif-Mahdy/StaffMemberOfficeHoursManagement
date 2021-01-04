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
import java.util.List;

@WebServlet(name = "UpdateProfile", value = "/UpdateProfile")
public class UpdateProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String username=request.getParameter("userName");
   String password=request.getParameter("password");
   String phoneNumber =request.getParameter("phoneNumber");
   String email =request.getParameter("email");
    String loginType=  request.getSession().getAttribute("loginType").toString();
    String userId=request.getSession().getAttribute("id").toString();
    if(loginType.equals("student"))
    {
        //if email changed , check if there is exist another account with this mail
        StudentEntity student=StudentCrud.findStudent(userId);
        if(!student.getStudentEmail().equals(email))
        {
            List<StudentEntity> students=StudentCrud.finStudentByAtt("StudentEmail",email);
            if(students.size()>0)
            {
                ///TODO: handle this exception for student
               // out.print("email is exist");
            }
            else {

                student.setStudentEmail(email);
            }

        }
        student.setStudentPassword(password);
        student.setStudentName(username);
        student.setStudentNumber(phoneNumber);
        StudentCrud.updateStudent(student);



    }
else if (loginType.equals("staff"))
    {
        StaffmemberEntity staff= StaffMemberCrud.findStaffMember(userId);
        if(!staff.getStaffEmail().equals(email))
        {
            List<StaffmemberEntity> staffs=StaffMemberCrud.findStaffByAtt("StudentEmail",email);
            if(staffs.size()>0)
            {
                ///TODO: handle this exception for staff
                // out.print("email is exist");
            }
            else {

                staff.setStaffEmail(email);
            }

        }
        staff.setStaffPassword(password);
        staff.setStaffName(username);
        staff.setStaffNumber(phoneNumber);
        StaffMemberCrud.updateStaff(staff);

    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
