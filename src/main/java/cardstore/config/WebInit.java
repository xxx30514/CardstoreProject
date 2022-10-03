package cardstore.config;

import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/**
 * 代替web.xml
 */


//public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

//	@Override
	// 設置配置類,代替spring配置文件
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { SpringConfig.class };
//	}

//	@Override
	// 設置配置類,代替springmvc配置文件
//	protected Class<?>[] getServletConfigClasses() {
		
//		return  new Class[] { WebConfig.class };
//	}

//	@Override
	// 設置SpringMVC的前端控制器DispatcherServlet的url-pattern
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}

//	@Override
	// 設置過濾器
//	protected Filter[] getServletFilters() {
		// 建立編碼過濾器
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("UTF-8");
//		characterEncodingFilter.setForceEncoding(true);
//		// 建立處理請求方式的過濾器
//		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
//		return new Filter[] { characterEncodingFilter, hiddenHttpMethodFilter };
//	}
	
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//		rootContext.register(WebConfig.class);
//		rootContext.setServletContext(servletContext);	
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//		ServletRegistration.Dynamic mvc = servletContext.addServlet("mvc", new DispatcherServlet(rootContext));
//		mvc.setLoadOnStartup(1);
//		mvc.addMapping("/");
//		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("endcodingFilter", new CharacterEncodingFilter());
//		filterRegistration.setInitParameter("encoding", "UTF-8");
//		filterRegistration.setInitParameter("forceEncoding", "true");
//		filterRegistration.addMappingForUrlPatterns(null, false, "/*");
//		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
//		filterRegistration.addMappingForServletNames(null, true, "CardstoreSSM");
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//	}
//}
