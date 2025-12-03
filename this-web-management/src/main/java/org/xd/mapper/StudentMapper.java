package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xd.pojo.Student;
import org.xd.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    
    /**
     * 条件分页查询学生列表
     * @param param
     * @return
     */
    List<Student> list(StudentQueryParam param);

    /**
     * 新增学生
     * @param student
     */
    void insert(Student student);

    /**
     * 根据ID查询学生
     * @param id
     * @return
     */
    Student getById(Integer id);

    /**
     * 修改学生信息
     * @param student
     */
    void updateById(Student student);

    /**
     * 根据ID删除学生
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 违纪处理 - 更新违纪次数和违纪扣分
     * @param id
     * @param score
     */
    @Update("UPDATE student SET violation_count = violation_count + 1, violation_score = violation_score + #{score} WHERE id = #{id}")
    void updateViolation(Integer id, Integer score);

    /**
     * 根据班级ID查询学生数量
     * @param clazzId
     * @return
     */
    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{clazzId}")
    Long countByClazzId(Integer clazzId);

    /**
     * 统计每个班级的人数
     * @return
     */
    List<Map<String, Object>> countStudentByClazz();

    /**
     * 统计学生的学历信息
     * @return
     */
    List<Map<String, Object>> countStudentByDegree();
}
