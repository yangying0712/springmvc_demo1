package org.xd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xd.pojo.EmpLog;

import java.util.List;

@Mapper
public interface EmpLogMapper {
    /**
     * 插入日志
     */
    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    void insert(EmpLog empLog);

    /**
     * 查询所有日志
     */
    @Select("SELECT id, operate_time, info FROM emp_log ORDER BY operate_time DESC")
    List<EmpLog> list();
}