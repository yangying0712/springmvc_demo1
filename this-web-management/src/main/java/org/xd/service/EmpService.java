package org.xd.service;

import org.xd.pojo.Emp;
import org.xd.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
                         LocalDate begin, LocalDate end);
}
