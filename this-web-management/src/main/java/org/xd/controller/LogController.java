package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xd.pojo.EmpLog;
import org.xd.pojo.LogQueryParam;
import org.xd.pojo.PageResult;
import org.xd.pojo.Result;
import org.xd.service.EmpLogService;

/**
 * 日志管理
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private EmpLogService empLogService;

    /**
     * 分页查询日志列表
     */
    @GetMapping("/page")
    public Result page(LogQueryParam param) {
        log.info("分页查询日志列表: {}", param);
        PageResult<EmpLog> pageResult = empLogService.list(param);
        return Result.success(pageResult);
    }
}
