package org.xd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClazzServiceTest {

    @Autowired
    private ClazzService clazzService;

    @Test
    public void testList() {
        ClazzQueryParam param = new ClazzQueryParam();
        param.setPage(1);
        param.setPageSize(10);
        
        PageResult<Clazz> result = clazzService.list(param);
        
        assertNotNull(result);
        assertNotNull(result.getRows());
        
        // 验证班级状态字段存在
        if (!result.getRows().isEmpty()) {
            Clazz clazz = result.getRows().get(0);
            assertNotNull(clazz.getStatus());
            assertTrue(clazz.getStatus().equals("未开班") || 
                      clazz.getStatus().equals("在读中") || 
                      clazz.getStatus().equals("已结课"));
        }
    }

    @Test
    public void testListAll() {
        List<Clazz> clazzList = clazzService.listAll();
        
        assertNotNull(clazzList);
        
        // 验证所有班级都有状态
        for (Clazz clazz : clazzList) {
            assertNotNull(clazz.getStatus());
        }
    }
}
