package cardstore.practice;

import cardstore.service.UserService;

public class UserController {
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void saveUser() {
		userService.saveUser();
	}
}
