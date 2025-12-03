package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.xd.pojo.Student;

@Mapper
public interface StudentMapper {
    
    /**
     * 更新学生违纪信息
     */
    @Update("update student set violation_count = #{violationCount}, violation_score = #{violationScore}, update_time = #{updateTime} where id = #{id}")
    void updateViolation(Student student);
}
