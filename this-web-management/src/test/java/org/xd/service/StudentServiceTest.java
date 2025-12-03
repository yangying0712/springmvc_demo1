package org.xd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xd.pojo.PageResult;
import org.xd.pojo.Student;
import org.xd.pojo.StudentQueryParam;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testList() {
        StudentQueryParam param = new StudentQueryParam();
        param.setPage(1);
        param.setPageSize(10);
        
        PageResult<Student> result = studentService.list(param);
        
        assertNotNull(result);
        assertNotNull(result.getRows());
    }
}
