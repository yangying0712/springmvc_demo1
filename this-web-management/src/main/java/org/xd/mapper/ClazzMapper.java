package org.xd.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    /**
     * 列出所有班级
     */
    List<Clazz> list(ClazzQueryParam param);
    
    /**
     * 统计各个班级的学生人数
     */
    @MapKey("name")
    List<Map<String, Object>> countClazzStudentData();
}
