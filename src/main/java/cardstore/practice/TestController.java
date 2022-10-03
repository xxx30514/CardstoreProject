package cardstore.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cardstore.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	//@Qualifier("testServiceImpl")
	private TestService testService;
	
	public void saveTest() {
		testService.saveTest();
	}
}
