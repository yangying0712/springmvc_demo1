package org.xd.service;

import org.xd.pojo.Emp;
import org.xd.pojo.EmpQueryParam;
import org.xd.pojo.LoginInfo;
import org.xd.pojo.PageResult;

import java.util.List;

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
    void save(Emp emp) throws Exception;

    /**
     * 删除员工
     * @param ids 员工id列表
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 员工对象
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    LoginInfo login(Emp emp);
}
