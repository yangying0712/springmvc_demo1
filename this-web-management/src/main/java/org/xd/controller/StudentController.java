package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xd.pojo.PageResult;
import org.xd.pojo.Result;
import org.xd.pojo.Student;
import org.xd.pojo.StudentQueryParam;
import org.xd.service.StudentService;

/**
 * 学员管理
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 条件分页查询学生列表
     */
    @GetMapping
    public Result list(StudentQueryParam param) {
        log.info("条件分页查询学生列表: {}", param);
        PageResult<Student> pageResult = studentService.list(param);
        return Result.success(pageResult);
    }

    /**
     * 新增学生
     */
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("新增学生: {}", student);
        studentService.add(student);
        return Result.success();
    }

    /**
     * 根据ID查询学生
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询学生: {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学生信息
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息: {}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 根据ID删除学生
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除学生: {}", id);
        studentService.deleteById(id);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PostMapping("/{id}/{score}")
    public Result handleViolation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪处理: id={}, score={}", id, score);
        studentService.handleViolation(id, score);
        return Result.success();
    }
}
