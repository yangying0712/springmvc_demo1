package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xd.pojo.Emp;
import org.xd.pojo.EmpQueryParam;
import org.xd.pojo.PageResult;
import org.xd.pojo.Result;
import org.xd.service.EmpService;

import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

/*    @GetMapping
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name, Integer gender,
            @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询： page={}, pageSize={},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }*/
    @GetMapping
    public Result page(EmpQueryParam  param){
        log.info("分页查询： {}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

/*    *//**
     * 删除员工
     *//*
    @DeleteMapping
    public Result delete(Integer[] ids){
        log.info("删除员工：{}", Arrays.toString(ids));
//        empService.delete(id);
        return Result.success();
    }*/
    /**
     * 删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工信息：{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    /**
     * 修改员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }

}

/*@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page ,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("查询员工信息, page={}, pageSize={}", page, pageSize);
        PageResult pageResult = empService.page(page, pageSize);
        return Result.success(pageBean);
    }

}*/
