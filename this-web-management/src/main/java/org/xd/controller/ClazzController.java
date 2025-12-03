package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;
import org.xd.pojo.Result;
import org.xd.service.ClazzService;

import java.util.List;

/**
 * 班级管理
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 条件分页查询班级列表
     */
    @GetMapping
    public Result list(ClazzQueryParam param) {
        log.info("条件分页查询班级列表: {}", param);
        PageResult<Clazz> pageResult = clazzService.list(param);
        return Result.success(pageResult);
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result listAll() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.listAll();
        return Result.success(clazzList);
    }

    /**
     * 新增班级
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("新增班级: {}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 根据ID删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除班级: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }
}
