package org.xd.mapper;

import org.apache.ibatis.annotations.*;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 条件分页查询班级列表
     */
    List<Clazz> list(ClazzQueryParam param);

    /**
     * 查询所有班级
     */
    @Select("SELECT id, name, room, begin_date, end_date, master_id, subject, create_time, update_time FROM clazz ORDER BY id DESC")
    List<Clazz> listAll();

    /**
     * 新增班级
     */
    @Insert("INSERT INTO clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "VALUES(#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    Clazz getById(Integer id);

    /**
     * 修改班级信息
     */
    void updateById(Clazz clazz);

    /**
     * 根据ID删除班级
     */
    @Delete("DELETE FROM clazz WHERE id = #{id}")
    void deleteById(Integer id);
}
