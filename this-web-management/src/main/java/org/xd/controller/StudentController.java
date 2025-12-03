package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xd.pojo.Result;
import org.xd.pojo.Student;
import org.xd.service.StudentService;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    /**
     * 更新学生违纪信息
     */
    @PutMapping("/violation")
    public Result updateViolation(@RequestBody Student student) {
        log.info("更新学生违纪信息：{}", student);
        studentService.updateViolation(student);
        return Result.success();
    }
}
