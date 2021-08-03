package com.wuqihu.dao;

import com.wuqihu.domain.Student;

public interface StudentDao {
    public Student getById(Integer id);
    public void save(Student student);

}
