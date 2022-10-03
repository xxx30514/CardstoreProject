package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cardstore.aop_annotation.Calculator;


public class AOPTest {
	//AOP代理 只能透過代理對象存取
	@Test
	public void testAOP() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aop.xml");
		Calculator calculator = ioc.getBean(Calculator.class);
		calculator.add(1, 2);
		calculator.div(10, 5);
		ioc.close();
	}
}
