import com.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Test", value = "/Test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
//        System.out.println(id);
        List<CourseEntity> course= CourseCrud.findCourseByAtt("courseName",courseName);
        System.out.println("course if is " + course.get(0).getCourseId());
        List<String>staffIds= CourseToStaffCrud.selectAllStaffForCourse(course.get(0).getCourseId());
        List<StaffmemberEntity>staff=new ArrayList<>();
        for (String staffId:
             staffIds) {
            staff.add(StaffMemberCrud.findStaffMember(staffId));

        }
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writeValueAsString(staff);
        System.out.println(json);
        PrintWriter out =response.getWriter();
        out.print(json);


    }
}
