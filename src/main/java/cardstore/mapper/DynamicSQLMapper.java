package cardstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cardstore.pojo.Emp;

public interface DynamicSQLMapper {
	//條件查詢 不知道有一筆還多筆資料用集合裝
	List<Emp> getEmpByCondition(Emp emp);
	
	//使用choose查詢員工資訊
	List<Emp> getEmpByChoose(Emp emp);
	
	
	//批量新增員工
	void insertMoerEmp(@Param("emps") List<Emp> emps);
	
	//批量刪除員工
	void deleteMoerEmp(@Param("empIds") Integer[] empIds);
}
