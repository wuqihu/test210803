import com.wuqihu.domain.Student;
import com.wuqihu.service.StudentService;
import com.wuqihu.service.impl.StudentServiceImpl;
import com.wuqihu.util.ServiceFactory;

public class Test01 {
    public static void main(String[] args) {
        //StudentService studentService=new StudentServiceImpl();
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        Student student =new Student();
        student.setId(1004);
        student.setAge(24);
        student.setEmail("l4@qq.com");
        student.setName("l4");
        studentService.save(student);
    }
}
