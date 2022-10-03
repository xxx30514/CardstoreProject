package cardstore.dao.impl;



import org.springframework.stereotype.Repository;

import cardstore.dao.TestDao;

@Repository
public class TestDaoImpl implements TestDao{
	
	
	@Override
	public void saveTest() {
		System.out.println("註解配置測試成功");
	}

}
