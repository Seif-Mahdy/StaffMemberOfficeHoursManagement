import com.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddMessage", value = "/AddMessage")
public class AddMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String senderId = request.getSession().getAttribute("id").toString();
        String senderEmail = null;
        PrintWriter out = response.getWriter();

        if (request.getSession().getAttribute("loginType").toString().equals("student")) {
            StudentEntity student = StudentCrud.findStudent(senderId);
            senderEmail = student.getStudentEmail();
        } else {
            StaffmemberEntity staff = StaffMemberCrud.findStaffMember(senderId);
            senderEmail = staff.getStaffEmail();
        }
        MessageEntity message = new MessageEntity();

        String receiverMail = request.getParameter("toEmail");

        List<StudentEntity> tempStudent = StudentCrud.findStudentByAtt("studentEmail", receiverMail);
        List<StaffmemberEntity> tempStuff = StaffMemberCrud.findStaffByAtt("staffEmail", receiverMail);
        boolean isValidData = true;
        if (tempStudent.size() > 0) {
            message.setReceiverId(tempStudent.get(0).getStudentId());
        } else if (tempStuff.size() > 0) {
            message.setReceiverId(tempStuff.get(0).getStaffId());
        } else // receiver mail does not exist
        {
            isValidData = false;
            out.print("Cannot find this email!");
        }
        if (isValidData) {
            String messageContent = request.getParameter("message");
            String subject = request.getParameter("subject");
            message.setMessageContent(messageContent);
            message.setSubject(subject);
            message.setSenderId(senderId);
            Date date = new Date();

            message.setMessageDate(new Timestamp(date.getTime()));
            if (RegisterationMail.sendMail(receiverMail, senderEmail, subject, messageContent) && MessageCrud.addMessage(message)) {
                out.print("success");
            } else {
                out.print("Failed to send message");
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
