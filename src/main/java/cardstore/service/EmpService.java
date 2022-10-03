package cardstore.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cardstore.pojo.Emp;

public interface EmpService {
	//查詢所有員工
	List<Emp> getAllEmp();
	//獲取分頁資訊
	PageInfo<Emp> getEmpPage(Integer pageNo);

}
