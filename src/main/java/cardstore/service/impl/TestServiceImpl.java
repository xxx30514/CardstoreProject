package cardstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardstore.dao.TestDao;
import cardstore.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDao testDao;
	
	@Override
	public void saveTest() {
		
		testDao.saveTest();
		
	}

}
