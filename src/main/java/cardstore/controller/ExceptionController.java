package cardstore.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//將當前類標示為異常處理組件
@ControllerAdvice
public class ExceptionController {
	//設置要處理的異常
	@ExceptionHandler(ArithmeticException.class)
	public String handleException(Throwable ex ,Model model) {
		//ex表示出現的異常
		model.addAttribute("ex",ex);
		return "error";
	}
}
