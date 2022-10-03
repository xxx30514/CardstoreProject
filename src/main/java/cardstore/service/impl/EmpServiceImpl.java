package cardstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cardstore.mapper.EmpMapper;
import cardstore.pojo.Emp;
import cardstore.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<Emp> getAllEmp() {
		return empMapper.getAllEmp();
	}

	@Override
	public PageInfo<Emp> getEmpPage(Integer pageNo) {
		//開啟分頁功能
		PageHelper.startPage(pageNo,2);
		//查詢所有員工資訊
		List<Emp> list = empMapper.getAllEmp();
		//獲取分頁資訊
		PageInfo<Emp> page = new PageInfo<>(list,5);
		return page;
	}
	
	
	
}
