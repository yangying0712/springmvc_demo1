package org.xd.service;

import org.xd.pojo.Student;

public interface StudentService {
    
    /**
     * 更新学生违纪信息
     */
    void updateViolation(Student student);
}
