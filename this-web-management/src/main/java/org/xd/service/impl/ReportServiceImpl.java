package org.xd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.ClazzMapper;
import org.xd.mapper.EmpMapper;
import org.xd.pojo.JobOption;
import org.xd.service.ReportService;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public JobOption getEmpJobData() {
        //1.统计各个职位的员工人数
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //2.封装成JobOption对象
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
    
    @Override
    public JobOption getClazzStudentData() {
        //1.统计各个班级的学生人数
        List<Map<String, Object>> list = clazzMapper.countClazzStudentData();
        //2.封装成JobOption对象，横坐标为班级名称，纵坐标为学生人数
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();

        return new JobOption(clazzList, dataList);
    }
}
