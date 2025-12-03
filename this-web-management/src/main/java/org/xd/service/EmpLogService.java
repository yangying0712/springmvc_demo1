package org.xd.service;

import org.xd.pojo.EmpLog;
import org.xd.pojo.LogQueryParam;
import org.xd.pojo.PageResult;

public interface EmpLogService {
    /**
     * 记录新增员工日志
     */
    void insertLog(EmpLog empLog);

    /**
     * 分页查询日志列表
     */
    PageResult<EmpLog> list(LogQueryParam param);
}