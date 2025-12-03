package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.xd.mapper.EmpExprMapper;
import org.xd.mapper.EmpMapper;
import org.xd.pojo.*;
import org.xd.service.EmpLogService;
import org.xd.service.EmpService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


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
/*    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
                                LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        //不用强转，直接PageInfo<Emp> p = new PageInfo<>(list);把list丢进去
//        List<Emp> empList = empMapper.list();
//        Page<Emp> empPage = (Page<Emp>) empList;
        Page<Emp> empPage = (Page<Emp>) empMapper.list(name, gender,
                begin,end);
        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }*/
    @Override
    public PageResult<Emp> page(EmpQueryParam  param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //不用强转，直接PageInfo<Emp> p = new PageInfo<>(list);把list丢进去
    //        List<Emp> empList = empMapper.list();
    //        Page<Emp> empPage = (Page<Emp>) empList;
    //    Page<Emp> empPage = (Page<Emp>) empMapper.list(param.getName(), param.getGender(),
    //            param.getBegin(),param.getEnd());
        Page<Emp> empPage = (Page<Emp>) empMapper.list(param);

        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            //1.补全基础属性
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());

            //2.保存员工基本信息
            empMapper.insert(emp);

//            int i=1/0;

            //3. 保存员工的工作经历信息 - 批量
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> empExpr.setEmpId(empId));
               empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //1. 删除员工
        empMapper.deleteByIds(ids);
        //2. 删除员工对应的工作经历
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        //1.根据ID修改员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        //2.修改员工对应的工作经历
        //2.1 删除员工对应的所有工作经历
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        //2.2 添加员工新的工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            Integer empId = emp.getId();
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public LoginInfo login(Emp emp) {
        //1. 根据用户名和密码查询
        Emp e= empMapper.selectByUsernameAndPassword(emp);
        //2. 判断结果, 如果存在，组装登录信息并返回
        if (e != null) {
            log.info("员工登录成功：{}", e);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), "admin-token");
        }
        //3. 不存在，返回null
        return null;
    }

    @Override
    public List<Emp> listAll() {
        EmpQueryParam param = new EmpQueryParam();
        return empMapper.list(param);
    }
}
