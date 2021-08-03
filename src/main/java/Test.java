import com.wuqihu.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        String cnofig = "mybatis.xml";
        InputStream inputStream =null;
        try {
            inputStream= Resources.getResourceAsStream(cnofig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student =sqlSession.selectOne("com.wuqihu.StudentMapper.selectStudentById",1001);
        System.out.println(student);
        sqlSession.close();
    }
}
