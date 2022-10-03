package cardstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * 攔截器的三個方法
 * preHandle():在控制器方法執行前執行 ,其返回值表示對控制器方法的攔截(false)或放行(true)
 * postHandle():在控制器方法執行後執行
 * afterCompletion():控制器方法執行之後,且渲染視圖完畢後執行	
 * 
 * 多個攔截器的執行順序:與springmvc配置文件的配置順序有關 
 * preHandle():先配置先執行
 * postHandle()、afterCompletion():後配置先執行
 * 
 * 若有某個攔截器的preHandle()方法返回false 返回false的攔截器與他之前的攔截器都會執行preHandle()方法
 * 所有攔截器的postHandle()都不執行
 * afterCompletion() 返回false之前的攔截器會執行afterCompletion()方法
 */
public class FirstInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" FirstInterceptor-->preHandle");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(" FirstInterceptor-->postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(" FirstInterceptor-->afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
