package cardstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cardstore.pojo.Emp;

public interface EmpMapper {
	//查詢所有員工
	List<Emp> getAllEmp();
	//根據ID查詢員工資訊
	Emp getEmpByEmpId(@Param("empId") Integer empId);
	
	//根據ID獲取員工資訊與部門ID
	Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
	
	//分步查詢第一步
	Emp getEmpAndDeptByStep(@Param("empId") Integer empId);
	
	//一對多分步查詢第二步
	List<Emp> getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
}
