package org.xd.service;

import org.xd.pojo.EmpLog;

public interface EmpLogService {
    //记录新增员工日志
    public void insertLog(EmpLog empLog);
}