package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.xd.mapper.EmpLogMapper;
import org.xd.pojo.EmpLog;
import org.xd.pojo.LogQueryParam;
import org.xd.pojo.PageResult;
import org.xd.service.EmpLogService;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)//需要新启一个事务
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

    @Override
    public PageResult<EmpLog> list(LogQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        Page<EmpLog> logList = (Page<EmpLog>) empLogMapper.list();
        //3. 封装分页结果
        return new PageResult<>(logList.getTotal(), logList.getResult());
    }
}