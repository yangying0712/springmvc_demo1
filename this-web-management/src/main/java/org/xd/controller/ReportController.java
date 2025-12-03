package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xd.pojo.JobOption;
import org.xd.pojo.Result;
import org.xd.service.ReportService;

import java.util.List;
import java.util.Map;

/**
 * 报表统计
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计各个性别的员工人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计各个性别的员工人数");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计每个班级的学生人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计每个班级的学生人数");
        JobOption jobOption = reportService.getStudentCountData();
        return Result.success(jobOption);
    }

    /**
     * 统计学生的学历信息
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学生的学历信息");
        List<Map<String, Object>> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }
}
