package cardstore.mapper;

import org.apache.ibatis.annotations.Param;

import cardstore.pojo.Dept;

public interface DeptMapper {
	//多對一分步查詢第二步 emp為主表
	Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer detpId);
	
	//查詢部門與部門中的員工資訊 一對多
	Dept getDeptAndEmpByDeptId(@Param("deptId") Integer detpId);
	
	//分步查詢 一對多 dept為主表  查詢部門與部門中的員工資訊第一步
	Dept getDeptAndEmpByStepOne(@Param("deptId") Integer detpId);
}
