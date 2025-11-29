package org.xd.service;

import org.xd.pojo.Emp;
import org.xd.pojo.EmpQueryParam;
import org.xd.pojo.PageResult;

public interface EmpService {
/*    *
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
/*    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
                         LocalDate begin, LocalDate end);*/

    /**
     * 分页查询
     * @param param 查询参数
     */
    PageResult<Emp> page(EmpQueryParam  param);

    /**
     * 添加员工
     * @param emp 员工数据
     */
    void save(Emp emp);
}
