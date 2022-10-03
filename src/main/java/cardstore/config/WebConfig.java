package cardstore.config;

import java.util.List;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import cardstore.interceptor.FirstInterceptor;

/**
 * 代替SpringMVC配置文件 掃描組件、視圖解析器、預設的servlet、mvc的註解驅動 視圖控制器、文件上傳解析器、攔截器、異常解析器
 */
//@Configuration // 將當前類標示為配置類
//@ComponentScan("cardstore") // 掃描組件
//@EnableWebMvc // 開啟MCV註解驅動
public class WebConfig implements WebMvcConfigurer {

	@Override
	// 以預設的servlet處理靜態資源
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	// 設置視圖控制器 /與/index 路徑會跳轉到index視圖
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		WebMvcConfigurer.super.addViewControllers(registry);
	}

	@Bean //  將標示方法的返回值作為bean進行管理,bean的id為該方法的方法名
	//文件上傳解析器
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		FirstInterceptor firstInterceptor = new FirstInterceptor();
		registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
	}

	@Override
	// 配置異常解析器
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties prop = new Properties();
		// 要處理的異常 與跳轉的視圖
		prop.setProperty("java.lang.ArithmeticException", "error");
		exceptionResolver.setExceptionMappings(prop);
		// 共享請求域的屬性
		exceptionResolver.setExceptionAttribute("exception");
		resolvers.add(exceptionResolver);
	}

	// 建立模板解析器
	@Bean
	public ITemplateResolver templateResolver() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		// ServletContextTemplateResolver需要一個ServletContext作為建構參數，可透過WebApplicationContext的方法獲得
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
		webApplicationContext.getServletContext());
		templateResolver.setPrefix("/WEB-INF/pages/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}

	// 建立模板引擎並注入模板解析器 
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}

	// 建立視圖解析器並注入模板引擎
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setOrder(1);
		return viewResolver;
	}
}
