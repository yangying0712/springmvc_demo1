package org.xd.mapper;

import org.apache.ibatis.annotations.*;
import org.xd.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有的部门信息
     * @return 部门列表
     */

    //    方式一，手动结果映射
    //    @Results({
    //            @Result(column = "create_time",property ="createTime" ),
    //            @Result(column = "update_time",property ="updateTime" )
    //    })

    //方式二，起用别名
    //@Select("SELECT id, name, create_time createTime, update_time updateTime FROM dept order by update_time desc;")
    @Select("SELECT id, name, create_time, update_time FROM dept order by update_time desc;")
    List<Dept> findAll() ;


    /**
     * 根据ID删除部门
     * @param id
     */
    @Delete("DELETE FROM dept WHERE id=#{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("INSERT INTO dept(name, create_time, update_time) VALUES(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    @Select("SELECT id, name, create_time, update_time FROM dept WHERE id=#{id}")
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    @Update("UPDATE dept SET name=#{name}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Dept dept);
}
