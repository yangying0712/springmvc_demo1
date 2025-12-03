package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;
import org.xd.pojo.Result;
import org.xd.service.ClazzService;

@Slf4j
@RestController // 或 @Controller
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    /**
     * 获取班级列表(含分页)
     */
    @GetMapping
    public Result list(ClazzQueryParam  param) {
        log.info("获取班级列表(含分页): {}", param);
        PageResult<Clazz> pageResult = clazzService.list(param);
        return Result.success(pageResult);
    }
}
