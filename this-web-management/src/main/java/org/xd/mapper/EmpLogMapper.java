package org.xd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xd.pojo.EmpLog;

import java.util.List;

@Mapper
public interface EmpLogMapper {
    //插入日志
    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(EmpLog empLog);
    
    //查询所有日志
    @Select("select id, operate_time, info from emp_log order by operate_time desc")
    public List<EmpLog> list();
}