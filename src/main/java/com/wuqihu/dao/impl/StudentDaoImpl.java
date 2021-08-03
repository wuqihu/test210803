package com.wuqihu.dao.impl;

import com.wuqihu.dao.StudentDao;
import com.wuqihu.domain.Student;
import com.wuqihu.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {


    @Override
    public Student getById(Integer id) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        Student student=sqlSession.selectOne("com.wuqihu.StudentMapper.selectStudentById",1001);
        return student;
    }

    @Override
    public void save(Student student) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        sqlSession.insert("com.wuqihu.StudentMapper.save",student);
    }
}
