package org.xd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.xd.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
//    void insertBatch(List<EmpExpr> exprList);

    void insertBatch(List<EmpExpr> exprList);
}