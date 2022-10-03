package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.practice.UserController;

public class AutowireTest {
	/*
	 * 自動配置:根據指定策略在IOC容器中配置某個bean自動為bean中的類類型屬性或介面類型的屬性賦值
	 * bean標籤中的autowire屬性來決定配置策略autowire="byType"
	 * 1.no,default 即不裝配,不會自動配置某個bean為屬性賦值
	 * 2.**常用byType:根據要賦值的屬性類型 在IOC容器中配對某個bean 為屬性賦值 *必須只有一個符合的bean 才能為屬性賦值
	 * 若一個bean都無法配對,此時就不配對,由於屬性使用預設值null=>NullPointer
	 * 若有超過一個符合條件的bean(不同id 同一類)=>NoUniqueBeanDefinition
	 * 3.byName:根據類的屬性名自動裝配 將當前要賦值的屬性名作為beanId 在IOC容器中配對某個bean來賦值 
	 * 有多個類符合時可用byName 一般情況不會使用
	*/
	@Test
	public void testAutowireByXML() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
		UserController userController = ioc.getBean(UserController.class);
		userController.saveUser();
		ioc.close();
	}
}
