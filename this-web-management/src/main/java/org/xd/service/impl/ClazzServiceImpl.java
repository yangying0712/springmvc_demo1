package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.ClazzMapper;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;
import org.xd.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper ClazzMapper;
    @Override
    public PageResult list(ClazzQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        Page<Clazz> clazzList = (Page<Clazz>)ClazzMapper.list(param);
        //3. 封装分页结果
//        Page<Clazz> p = (Page<Clazz>)clazzList;
        return new PageResult(clazzList.getTotal(), clazzList.getResult());
    }
}
