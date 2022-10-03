package cardstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewConrtoller {
	
	@RequestMapping("/test/view/thymeleaf")
	public String testThymeleafView() {
		
		return "success";
	}
	
	@RequestMapping("/test/view/forward")
	//forward 僅發送一次請求 url不會變動 
	public String testInternalResourceView() {
		//此方法不會經過thymeleaf渲染 較少使用
		return "forward:/test/model";
		
	}
	
	@RequestMapping("/test/view/redirect")
	//redirect 發送兩次請求 url會變動 
	public String testRedirectView() {
	
		return "redirect:/test/model";

	}
}
