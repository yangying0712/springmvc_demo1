package org.xd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.xd.pojo.Emp;
import org.xd.pojo.EmpExpr;
import org.xd.pojo.EmpQueryParam;

import java.util.List;

@Mapper
public interface EmpMapper {

/*    ***
     * 查询总记录数
     *//*
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    public Long count();

    *//**
     * 查询所有的员工及其对应的部门名称（分页查询）
     *//*
    @Select(
            "SELECT e.*, d.name AS deptName " +
                    "FROM emp AS e " +
                    "LEFT JOIN dept AS d ON e.dept_id = d.id " +
                    "ORDER BY e.update_time DESC " +
                    "LIMIT #{start}, #{pageSize}"
    )
    public List<Emp> list(Integer start, Integer pageSize);*/

//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
//    List<Emp> list(String name, Integer gender,
//                   LocalDate begin, LocalDate end);
    List<Emp> list(EmpQueryParam param);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username,name,gender,phone,job,salary,entry_date,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);



}
