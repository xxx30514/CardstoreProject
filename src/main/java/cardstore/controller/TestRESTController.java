package cardstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 查詢所有使用者資訊-->/user-->get
 * 根據ID查詢使用者資訊-->/user/1-->get
 * 新增使用者資訊-->/user-->post
 * 修改使用者資訊-->/user-->put
 * 根據ID刪除使用者資訊-->/user/1-->delete
 *
 * 瀏覽器僅能發送get與post請求
 * 若要發送put與delete需要在web.xml配置過濾器HiddenHttpMethodFilter
 * 配置過濾器後需要滿足兩個條件,才能夠將請求方式改為put或delete
 * 1.當前請求為post
 * 2.必須傳輸請求參數 _method,_method的值為請求方式
 */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Controller
public class TestRESTController {
	
	//@RequestMapping(value = "/user",method = RequestMethod.GET)
	@GetMapping("/user")
	public String getAllUser() {
		System.out.println("查詢所有使用者資訊-->/user-->get");
		return "success";
	}
	
	//@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable("id") Integer id) {
		System.out.println("根據ID查詢使用者資訊-->/user/"+id+"-->get");
		return "success";
	}
	
	//@RequestMapping(value = "/user",method = RequestMethod.POST)
	@PostMapping("/user")
	public String InsertUser() {
		System.out.println("新增使用者資訊-->/user-->post");
		return "success";
	}
	
	//@RequestMapping(value = "/user",method = RequestMethod.PUT)
	@PutMapping("/user")
	public String UpdateUser() {
		System.out.println("修改使用者資訊-->/user-->put");
		return "success";
	}
	
	//@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
	@DeleteMapping("/user/{id}")
	public String DeleteUpdateUser(@PathVariable("id") Integer id) {
		System.out.println("根據ID刪除使用者資訊-->/user/"+id+"-->delete");
		return "success";
	}
}
