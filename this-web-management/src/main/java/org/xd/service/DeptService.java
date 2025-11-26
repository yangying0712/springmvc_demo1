package org.xd.service;

import org.xd.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门信息
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 根据ID删除部门
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     */
    Dept getById(Integer id);

    /**
     * 修改部门信息
     * @param dept
     */
    void update(Dept dept);
}
