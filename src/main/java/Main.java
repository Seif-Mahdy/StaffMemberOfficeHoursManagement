import com.HybernateUtil;
import com.StudentCrud;
import com.StudentEntity;

public class Main {
    public static void main(final String[] args) throws Exception {

       /*
        StudentEntity student = new StudentEntity();
        student.setStudentName("Abdelrhman hosny awad");
        student.setStudentId("20170144");
        student.setStudentPassword("A01018236359");
        student.setStudentEmail("body.hosny111@gmail.com");
        student.setStudentNumber("01018236359");
        System.out.println(StudentCrud.addStudent(student)); */

        StudentEntity student2 ;
        student2=StudentCrud.findStudent("20170144");
        System.out.println(student2.getStudentName());
        StudentCrud.updateStudentById("20170144","StudentNumber","01018236358");
        System.out.println(student2.getStudentNumber());



    }

}
