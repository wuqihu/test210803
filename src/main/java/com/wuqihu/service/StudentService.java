package com.wuqihu.service;

import com.wuqihu.domain.Student;

public interface StudentService {
    public Student getById(Integer id);
    public void save(Student student);
}
