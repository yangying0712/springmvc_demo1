package org.xd.service;

import org.xd.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService{
    /**
     * 统计各个职位的员工人数
     */
    JobOption getEmpJobData();

    /**
     * 统计各个性别的员工人数
     */
    List<Map<String, Object>> getEmpGenderData();
    
    /**
     * 统计各个班级的学生人数
     */
    JobOption getClazzStudentData();
}
