package cardstore.mapper;

import org.apache.ibatis.annotations.Param;

import cardstore.pojo.Emp;

public interface CacheMapper {
	
	//根據ID查詢員工資訊
	Emp getEmpByEmpId(@Param("empId") Integer empId);
}
