package org.xd.service;

import org.xd.pojo.PageResult;
import org.xd.pojo.Student;
import org.xd.pojo.StudentQueryParam;

public interface StudentService {
    /**
     * 条件分页查询学生列表
     * @param param
     * @return
     */
    PageResult<Student> list(StudentQueryParam param);

    /**
     * 新增学生
     * @param student
     */
    void add(Student student);

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
    void update(Student student);

    /**
     * 根据ID删除学生
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 违纪处理
     * @param id 学生ID
     * @param score 扣分
     */
    void handleViolation(Integer id, Integer score);
}
