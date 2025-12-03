package org.xd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.exception.BusinessException;
import org.xd.mapper.ClazzMapper;
import org.xd.mapper.StudentMapper;
import org.xd.pojo.Clazz;
import org.xd.pojo.ClazzQueryParam;
import org.xd.pojo.PageResult;
import org.xd.service.ClazzService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> list(ClazzQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        Page<Clazz> clazzList = (Page<Clazz>) clazzMapper.list(param);
        //3. 计算班级状态
        LocalDate now = LocalDate.now();
        for (Clazz clazz : clazzList) {
            clazz.setStatus(calculateStatus(clazz, now));
        }
        //4. 封装分页结果
        return new PageResult<>(clazzList.getTotal(), clazzList.getResult());
    }

    @Override
    public List<Clazz> listAll() {
        List<Clazz> clazzList = clazzMapper.listAll();
        //计算班级状态
        LocalDate now = LocalDate.now();
        for (Clazz clazz : clazzList) {
            clazz.setStatus(calculateStatus(clazz, now));
        }
        return clazzList;
    }

    @Override
    public void add(Clazz clazz) {
        //1. 补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        //2. 调用Mapper方法，执行插入操作
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        Clazz clazz = clazzMapper.getById(id);
        if (clazz != null) {
            //计算班级状态
            clazz.setStatus(calculateStatus(clazz, LocalDate.now()));
        }
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        //1. 补全基础属性 - updateTime
        clazz.setUpdateTime(LocalDateTime.now());
        //2. 调用Mapper方法，执行更新操作
        clazzMapper.updateById(clazz);
    }

    @Override
    public void deleteById(Integer id) {
        //1. 检查班级下是否有学生
        Long count = studentMapper.countByClazzId(id);
        if (count > 0) {
            throw new BusinessException("对不起, 该班级下有学生, 不能直接删除");
        }
        //2. 删除班级
        clazzMapper.deleteById(id);
    }

    /**
     * 计算班级状态
     * - 当前时间 > 结课时间：状态为 已结课
     * - 当前时间 < 开课时间：状态为 未开班
     * - 否则：状态为 在读中
     */
    private String calculateStatus(Clazz clazz, LocalDate now) {
        if (clazz.getEndDate() != null && now.isAfter(clazz.getEndDate())) {
            return "已结课";
        } else if (clazz.getBeginDate() != null && now.isBefore(clazz.getBeginDate())) {
            return "未开班";
        } else {
            return "在读中";
        }
    }
}
