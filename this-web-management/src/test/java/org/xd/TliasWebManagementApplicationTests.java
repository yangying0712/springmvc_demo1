package org.xd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xd.mapper.EmpMapper;
import org.xd.pojo.Emp;

import java.util.List;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testList(){
        List<Emp> empList = empMapper.list(0, 10);
        empList.forEach(System.out::println);
    }
}
