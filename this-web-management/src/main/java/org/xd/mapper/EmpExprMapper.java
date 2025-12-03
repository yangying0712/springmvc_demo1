package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.xd.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
//    void insertBatch(List<EmpExpr> exprList);

    /**
     * 批量插入员工工作经历
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);
    /**
     * 根据员工id列表删除员工对应的工作经历
     * @param empIds
     */
    void deleteByEmpIds(List<Integer> empIds);
}