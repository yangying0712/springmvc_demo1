package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 列出所有班级
     */
    List<Clazz> list(ClazzQueryParam param);
}
