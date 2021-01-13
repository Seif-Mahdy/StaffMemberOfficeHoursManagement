import com.*;
import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddMessage")
public class AddMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //TODO: send message Attributes
    String senderId=request.getSession().getAttribute("id").toString();
        String senderEmail=null ;
    if(request.getAttribute("loginType").toString().equals("student"))
    {
        StudentEntity student= StudentCrud.findStudent(senderId);
        senderEmail=student.getStudentEmail();
    }
    else
    {
        StaffmemberEntity staff= StaffMemberCrud.findStaffMember(senderId);
        senderEmail=staff.getStaffEmail();
    }
        MessageEntity message=new MessageEntity();

        String receiverMail=request.getParameter("receiverMail");
        List<StudentEntity> tempStudent=StudentCrud.findStudentByAtt("studentEmail",receiverMail);
        List<StaffmemberEntity> tempStuff=StaffMemberCrud.findStaffByAtt("staffEmail",receiverMail);
    if(tempStudent.size()>0)
    {
        message.setReceiverId(tempStudent.get(0).getStudentId());
    }
    else if(tempStuff.size()>0)
    {
        message.setReceiverId(tempStuff.get(0).getStaffId());
    }
    String messageContent=request.getParameter("messageContent");
    String subject=request.getParameter("subject");
    message.setMessageContent(messageContent);
    message.setSubject(subject);
    message.setSenderId(senderId);
        PrintWriter out = response.getWriter();
    if( MessageCrud.addMessage(message) && RegisterationMail.sendMail(receiverMail,senderEmail,subject,messageContent) )
    {
        out.print("success");
    }
    else
    {
        out.print("Failed to send message");
    }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
