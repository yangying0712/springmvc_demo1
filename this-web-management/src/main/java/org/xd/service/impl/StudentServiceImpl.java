package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.StudentMapper;
import org.xd.pojo.PageResult;
import org.xd.pojo.Student;
import org.xd.pojo.StudentQueryParam;
import org.xd.service.StudentService;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> list(StudentQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        Page<Student> studentList = (Page<Student>) studentMapper.list(param);
        //3. 封装分页结果
        return new PageResult<>(studentList.getTotal(), studentList.getResult());
    }

    @Override
    public void add(Student student) {
        //1. 补全基础属性
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        //初始化违纪次数和违纪扣分
        if (student.getViolationCount() == null) {
            student.setViolationCount((short) 0);
        }
        if (student.getViolationScore() == null) {
            student.setViolationScore((short) 0);
        }
        //2. 调用Mapper方法，执行插入操作
        studentMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        //1. 补全基础属性 - updateTime
        student.setUpdateTime(LocalDateTime.now());
        //2. 调用Mapper方法，执行更新操作
        studentMapper.updateById(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void handleViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
