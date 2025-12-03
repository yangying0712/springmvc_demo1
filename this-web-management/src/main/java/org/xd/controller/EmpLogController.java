package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xd.pojo.EmpLog;
import org.xd.pojo.Result;
import org.xd.service.EmpLogService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/empLogs")
public class EmpLogController {

    @Autowired
    private EmpLogService empLogService;

    /**
     * 查询所有日志
     */
    @GetMapping
    public Result list() {
        log.info("查询所有日志");
        List<EmpLog> empLogs = empLogService.list();
        return Result.success(empLogs);
    }
}
