package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.EmpMapper;
import org.xd.pojo.Emp;
import org.xd.pojo.PageResult;
import org.xd.service.EmpService;

import java.time.LocalDate;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

/*    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long total = empMapper.count();

        //2. 获取结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize);

        //3. 封装结果
        return new PageResult<Emp>(total, empList);
    }*/
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
                                LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        //不用强转，直接PageInfo<Emp> p = new PageInfo<>(list);把list丢进去
//        List<Emp> empList = empMapper.list();
//        Page<Emp> empPage = (Page<Emp>) empList;
        Page<Emp> empPage = (Page<Emp>) empMapper.list(name, gender,
                begin,end);
        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }
}
