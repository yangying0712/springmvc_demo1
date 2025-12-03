package org.xd.service;

import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 条件分页查询班级列表
     */
    PageResult<Clazz> list(ClazzQueryParam param);

    /**
     * 查询所有班级
     */
    List<Clazz> listAll();

    /**
     * 新增班级
     */
    void add(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    Clazz getById(Integer id);

    /**
     * 修改班级信息
     */
    void update(Clazz clazz);

    /**
     * 根据ID删除班级
     */
    void deleteById(Integer id);
}
