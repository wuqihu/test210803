package com.wuqihu.service.impl;

import com.wuqihu.dao.StudentDao;
import com.wuqihu.dao.impl.StudentDaoImpl;
import com.wuqihu.domain.Student;
import com.wuqihu.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao=new StudentDaoImpl();
    @Override
    public Student getById(Integer id) {
        Student student=studentDao.getById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }
}
