package org.xd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.StudentMapper;
import org.xd.pojo.Student;
import org.xd.service.StudentService;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public void updateViolation(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateViolation(student);
    }
}
