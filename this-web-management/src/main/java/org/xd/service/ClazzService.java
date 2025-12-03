package org.xd.service;

import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;

public interface ClazzService {
    /**
     * 列出所有班级
     */
    PageResult<Clazz> list(ClazzQueryParam param);
}
