package cardstore.service.impl;

import cardstore.dao.UserDao;
import cardstore.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void saveUser() {
		
		userDao.saveUser();
	}
	
}
