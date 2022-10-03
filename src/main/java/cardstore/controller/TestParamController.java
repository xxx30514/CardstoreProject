package cardstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cardstore.pojo.User;
/*
 * 獲取請求參數方式
 * 1.servletAPI:設置HttpServletRequest類型形式參數,就可以透過request.getParameter獲取請求參數
 *** 2.透過控制器形式參數:在控制器方法中添加與請求參數(form中的name)同名的形式參數即可 **一般情況使用
 * public String gerParam(String username,String password)
 * 3.@RequestParam
 * value屬性:設置和形式參數綁定的請求參數@RequestParam("username") String username(形式參數) 
 * required屬性:設置是否必須傳輸value屬性對應的請求參數 預設為true 一定要傳輸value屬性對應的請求參數 @RequestParam("username") 
 * 若沒有傳輸userName=>400錯誤 設置為false時若未傳輸:形式參數值為null
 * defaultValue屬性:設置請求參數預設值@RequestParam("username") 若沒有傳輸username請求參數 傳輸預設值 與required屬性無關
 * 4.@RequestHeader:將請求頭資訊與控制器方法的形參綁定
 * 5.@CookieValue:將cookie資料與控制器方法的形參綁定
 * **6.通過實體類的形參獲取請求參數
 *7.解決獲取請求參數亂碼問題
 *在web.xml配置spring編碼過濾器CharacterEncodingFilter
*/
@Controller
public class TestParamController {

	@RequestMapping("/param/servletAPI") 
	public String getParamByServletAPI(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}
	
	@RequestMapping("/param") 
	//最常使用的方式 確保形式參數與請求參數同名即可
	public String getParam(String username,String password,
			@RequestHeader(value = "referer",required = false) String referer,
			@CookieValue("JSESSIONID") String jsessionId
	){
		System.out.println("username:"+username+",password:"+password);
		System.out.println("referer:"+referer);
		System.out.println("jsessionId:"+jsessionId);
		return "success";
	}
	
	@RequestMapping("/param/requestParam") 
	public String getParamByRequestParam(@RequestParam(value = "username",required = false,defaultValue = "guest") String username,String password) {
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}
	
	@RequestMapping("/param/pojo") 
	public String getParamByPojo(User user) {
		System.out.println(user);
		return "success";
	}
}
