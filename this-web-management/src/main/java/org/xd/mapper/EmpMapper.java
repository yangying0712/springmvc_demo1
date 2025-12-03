package org.xd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.xd.pojo.Emp;
import org.xd.pojo.EmpQueryParam;

import java.util.List;
import java.util.Map;

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
    @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID列表删除员工
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void updateById(Emp emp);

    /**
     * 统计员工数量
     * @return
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别数量
     * @return
     */
    @MapKey("gender")
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 根据用户名和密码查询员工
     * @param emp
     * @return
     */
    Emp selectByUsernameAndPassword(Emp emp);
}
