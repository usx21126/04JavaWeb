package com.xh.mapper;

import com.xh.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 新增员工经历
     * @param empExpr
     */
    void addEmpExpr(EmpExpr empExpr);

    /**
     * 批量添加员工经历
     * @param exprList
     */
    void addEmpExprBatch(List<EmpExpr> exprList);

    void deleteEmpExprs(List<Integer> ids);

    List<EmpExpr> getEmpExprById(Integer id);

    void deleteEmpExprById(Integer id);
}
