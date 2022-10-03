package cardstore.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 向請求域共享資料
 * 1.ModelAndView
 * 使用Model功能請求向請求域請求共享數據
 * 使用View功能設置邏輯視圖,控制器方法一定要將ModelAndView作為方法返回值 return mav;
 *2.Model
 *3.ModelMap
 *4.Map
 *5.Model、ModelMap、Map的關係 不論何種方式都會封裝成ModelAndView類型的物件
 *在底層中這些類型的形式參數都是通過BindingAwareModelMap建立
 */
@Controller
public class TestScopeController {
	
	@RequestMapping("/test/mav")
	public ModelAndView testMAV() {
		/**
		 * ModelAndView 包含Model和View功能
		 * Model:向請求域共享資料
		 * View:設置邏輯視圖實現跳轉
		 */
		ModelAndView mav = new ModelAndView();
		//向請求域共享資料
		mav.addObject("testRequestScope","hello,ModelAndView");
		//設置邏輯視圖
		mav.setViewName("success");
		return mav;
		
	}
	
	@RequestMapping("/test/model")
	public String testModel(Model model) {
		model.addAttribute("testRequestScope","helloModel");
		return "success";
	}
	
	@RequestMapping("/test/modelMap")
	public String testModelMap(ModelMap modelMap) {
		modelMap.addAttribute("testRequestScope","helloModelMap");
		return "success";
	}
	
	@RequestMapping("/test/map")
	public String testMap(Map<String, Object> map) {
		map.put("testRequestScope", "hello,Map");
		return "success";
	}
	
	@RequestMapping("/test/session")
	public String testSession(HttpSession session) {
		session.setAttribute("testSessionScope", "hello,session");
		return "success";
	}
	
	@RequestMapping("/test/application")
	public String testApplication(HttpSession session) {
		ServletContext servletContext = session.getServletContext();
		servletContext.setAttribute("testApplicationScope", "hello,application");
		return "success";
	}
}
