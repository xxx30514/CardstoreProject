package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.pojo.Emp;

public class ScopeTest {
	
	@Test
	public void testScope() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
		Emp emp1 = ioc.getBean(Emp.class);
		Emp emp2 = ioc.getBean(Emp.class);
		System.out.println(emp1.equals(emp2));//true 預設singleton
		ioc.close();
	}
}
