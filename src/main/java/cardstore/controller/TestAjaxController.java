package cardstore.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cardstore.pojo.TestUser;
/**
 * 1.@RequestBody 將請求體中的內容和控制器方法的形象參數綁定
 * 2.使用@RequestBody註解將json參數轉為java物件
 * 2-1.導入jackson的jar包
 * 2-2.在SpringMVC配置文件設置<mvc:annotation-driven />
 * 2-3.在處理請求的控制器方法的形象參數位置,直接設置json格式的請求參數轉換為java類型的形參,使用@RequestBody即可
 * 3.@ResponseBody:將所標示的控制器方法的返回值作為響應報文的響應體響應到瀏覽器上
 * 4.使用@ResponseBody向瀏覽器響應json格式的資料
 * 4-1.導入jackson的jar包
 * 4-2.在SpringMVC配置文件設置<mvc:annotation-driven />
 * 4-3.將需要轉換為json字串的java物件直接作為控制器方法的返回值,使用@ResponseBody註解標示控制器方法
 * 即可將java物件轉為json字串,響應到瀏覽器
 * 
 * 常用的java物件轉換為json的結果
 * 實體類-->json物件
 * map-->json物件
 * list-->json陣列
 * 
 */
@Controller
//@RestController  @Controller+@ResponseBody 幫類中所有方法都加上@ResponseBody 
public class TestAjaxController {
	
	@RequestMapping("/test/ajax")
	public void testAjax(Integer id ,@RequestBody String requsetBody,HttpServletResponse response) throws IOException {
		System.out.println("id:"+id);
		System.out.println("requsetBody:"+requsetBody);
		response.getWriter().write("hello,axios");
	}
	
	@RequestMapping("/test/RequestBody/json")
	public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
		System.out.println(map);
		response.getWriter().write("hello,RequestBody");
	}
	
	public void testRequestBody(@RequestBody TestUser testUser, HttpServletResponse response) throws IOException {
		System.out.println(testUser);
		response.getWriter().write("hello,RequestBody");
	}
	
	@RequestMapping("/test/ResponseBody")
	@ResponseBody 
	public String testResponseBody() {
		return "success";
	}
	
	@RequestMapping("/test/ResponseBody/json")
	@ResponseBody 
	/*實體類
	 * public TestUser testResponseBodyJson() {
		TestUser user = new TestUser(1001, "admin", "12345",20, "男");
		return user;
	}
	*/
	
	/*Map
	public Map<String, Object> testResponseBodyJson() {
		TestUser user1 = new TestUser(1001, "admin", "12345",20, "男");
		TestUser user2 = new TestUser(1002, "admin2", "12345",20, "男");
		TestUser user3 = new TestUser(1003, "admin3", "12345",20, "男");
		TestUser user4 = new TestUser(1004, "admin4", "12345",20, "男");
		Map<String, Object> map =new HashMap<>();
		map.put("1001", user1);
		map.put("1002", user2);
		map.put("1003", user3);
		map.put("1004", user4);
		return map;
	}
	*/
	public List<TestUser> testResponseBodyJson() {
		TestUser user1 = new TestUser(1001, "admin", "12345",20, "男");
		TestUser user2 = new TestUser(1002, "admin2", "12345",20, "男");
		TestUser user3 = new TestUser(1003, "admin3", "12345",20, "男");
		TestUser user4 = new TestUser(1004, "admin4", "12345",20, "男");
		List<TestUser> list = Arrays.asList(user1,user2,user3,user4);
		return list;
	}
}
