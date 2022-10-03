package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.pojo.HelloSpring;

public class HelloSpringTest {
	
	@Test
	public void helloTest() {
		//1.獲取IOC容器
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.獲取IOC容器中的bean物件
		HelloSpring helloSpring = ioc.getBean(HelloSpring.class);
		helloSpring.sayHello();
		//3.關閉資源
		ioc.close();
	}
}
