import com.*;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet(name = "/Register", value = "/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String registerType = request.getParameter("registerType");
        String captchaToken = request.getParameter("captchaToken");

        //System.out.println("captchaToken " + captchaToken);
        if (isCaptchaValid("6LeQpSEaAAAAAMVzbtFm_1AniSvqGDOOOoGHQp6k", captchaToken)) {
            System.out.println("captcha valid");
            if (!registerType.equals("null")) {

                StaffmemberEntity staff = StaffMemberCrud.findStaffMember(userID);
                List<StaffmemberEntity> staffByEmail = StaffMemberCrud.findStaffByAtt("staffEmail", email);
                List<StaffmemberEntity> staffByNumber = StaffMemberCrud.findStaffByAtt("staffNumber", phoneNumber);
                if (staff == null && staffByEmail.size() == 0 && staffByNumber.size() == 0) {
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
                List<StudentEntity> studentByEmail = StudentCrud.findStudentByAtt("studentEmail", email);
                List<StudentEntity> studentByNumber = StudentCrud.findStudentByAtt("studentNumber", phoneNumber);
                if (student == null && studentByNumber.size() == 0 && studentByEmail.size() == 0) {
                    student = new StudentEntity();
                    student.setStudentId(userID);
                    student.setStudentEmail(email);
                    student.setStudentName(userName);
                    student.setStudentNumber(phoneNumber);
                    student.setStudentPassword("123456789");
                    boolean isSent = RegisterationMail.sendMail(email);


                    if (isSent) {
                        request.getSession().setAttribute("success", "Account created successfully!");

                        boolean isAdded = StudentCrud.addStudent(student);
                        if (isAdded) {
                            out.print("success");
                        }
                    }
                } else {
                    out.print("There is already an account associated with these credentials!");
                }
            }
        } else {
            out.print("Captcha is invalid!");
        }
    }

    public synchronized boolean isCaptchaValid(String secretKey, String response) {
        try {
            String url = "https://www.google.com/recaptcha/api/siteverify",
                    params = "secret=" + secretKey + "&response=" + response;

            HttpURLConnection http = (HttpURLConnection) new URL(url).openConnection();
            http.setDoOutput(true);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded; charset=UTF-8");
            OutputStream out = http.getOutputStream();
            out.write(params.getBytes("UTF-8"));
            out.flush();
            out.close();

            InputStream res = http.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(res, "UTF-8"));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            JSONObject json = new JSONObject(sb.toString());
            res.close();

            return json.getBoolean("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

