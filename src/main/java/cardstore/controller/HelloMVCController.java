package cardstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*1.@RequestMapping 標示位置
 *@RequestMapping:標示一個類:設置映射請求的路徑初始資訊
 *@RequestMapping:標示一個方法:設置請求路徑的具體資訊
 *在類上@RequestMapping("/test")
 *在方法上@RequestMapping("/hello") =>路徑為/test/hello
 *避免不同方法使用同一個請求路徑@RequestMapping("/hello")
 *2.@RequestMapping value屬性(path)屬性
 *@RequestMapping({"/hello" ,"abc"}) 陣列類型 
 *發送請求路徑符合陣列中任一路徑 當前發送的請求便會處理被標註的方法
 *3.method屬性 表示請求方式 get post
 *若有設置method屬性 若請求路徑符合 但請求方式不符合 會有405錯誤 	不支持...方法
 *可以陣列方式設置 method = {RequestMethod.POST,RequestMethod.GET} 即兩種方法都會處理請求方法
 *4.在@RequestMapping基礎上結合請求方式 衍生註解
 *@GetMapping、@PostMapping
 *5.@RequestMapping的params屬性 基本上不會使用了
 *透過請求的請求參數符合請求 瀏覽器發送的請求參數必須滿足params屬性的設置
 *params的四種表示式	
 *5-1."params":請求參數中必須有params參數 
 *5-2."!params":請求參數中不能有params參數 
 *5-3."params=value":請求參數中必須有params參數 且值為value
 *5-4."!params=value":請求參數中必須有params參數 且值不能為value
 *6.@RequestMapping的header屬性 與params用法相似
 *7.SpringMVC支援ant風格路徑 @RequestMapping value屬性值設置特殊字元 
 *特殊字元?:任一個單一字元(不包括?)
 *特殊字元*:任意數量的字元(不包括?與/)
 *特數字元**:任意層數的任意目錄, **前後只能用/包覆 前後不能有其他字元
 *8.SpringMVC支援在路徑中使用占位符 
 *在@RequestMapping value屬性中以{參數名}表示路徑中的資料
 *再透過@PathVariable("參數名") 將占位符所標示的值與控制器中的形參綁定
 * */
@Controller
//@RequestMapping("/test")
public class HelloMVCController {
	
	/*
	@RequestMapping(path = {"/" ,"index"}) 
	public String index() {
		//返回邏輯視圖
		return "index";
	}
	*/
	
	@RequestMapping(value =  {"/hello" ,"/abc"},method = RequestMethod.GET)
	public String hello() {
		//返回邏輯視圖
		System.out.println(1/0);
		return "success";
	}
	
	@RequestMapping(value =  {"/hellopost"},method = {RequestMethod.POST,RequestMethod.GET})
	public String postHello() {
		//返回邏輯視圖
		return "success";
	}
	
	@RequestMapping(value =  {"/helloparams"},method = {RequestMethod.POST,RequestMethod.GET} ,params= {"username","!password","age=20","gender!=不知道"})
	public String helloparams() {
		//返回邏輯視圖
		return "success";
	}
	
	@RequestMapping("/**/test/ant")
	public String testAnt() {
		//返回邏輯視圖
		return "success";
	}
	
	
	@RequestMapping("/test/rest/{username}/{id}")
	//占位符路徑測試
	public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
		System.out.println("id:"+id+",username:"+username);
		//返回邏輯視圖
		return "success";
	}
}
