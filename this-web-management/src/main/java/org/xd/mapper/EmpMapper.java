package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xd.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    public Long count();

    /**
     * 查询所有的员工及其对应的部门名称（分页查询）
     */
    @Select(
            "SELECT e.*, d.name AS deptName " +
                    "FROM emp AS e " +
                    "LEFT JOIN dept AS d ON e.dept_id = d.id " +
                    "ORDER BY e.update_time DESC " +
                    "LIMIT #{start}, #{pageSize}"
    )
    public List<Emp> list(Integer start, Integer pageSize);
}
