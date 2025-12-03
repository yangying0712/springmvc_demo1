package org.xd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xd.pojo.JobOption;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReportServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void testGetStudentCountData() {
        JobOption result = reportService.getStudentCountData();
        
        assertNotNull(result);
        assertNotNull(result.getJobList());
        assertNotNull(result.getDataList());
        assertEquals(result.getJobList().size(), result.getDataList().size());
    }

    @Test
    public void testGetStudentDegreeData() {
        List<Map<String, Object>> result = reportService.getStudentDegreeData();
        
        assertNotNull(result);
        
        // 验证每个map包含name和value
        for (Map<String, Object> map : result) {
            assertTrue(map.containsKey("name"));
            assertTrue(map.containsKey("value"));
        }
    }
}
