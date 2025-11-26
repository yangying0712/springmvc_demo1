package org.xd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.mapper.DeptMapper;
import org.xd.pojo.Dept;
import org.xd.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //1.补全基础属性 - createTime,updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用Mapper方法，执行插入操作
        deptMapper.add(dept);
    }

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1.补全基础属性 - updateTime
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用Mapper方法，执行更新操作
        deptMapper.update(dept);
    }


}
