package org.xd.service;

import org.xd.pojo.EmpLog;

import java.util.List;

public interface EmpLogService {
    //记录新增员工日志
    public void insertLog(EmpLog empLog);
    
    //查询所有日志
    public List<EmpLog> list();
}