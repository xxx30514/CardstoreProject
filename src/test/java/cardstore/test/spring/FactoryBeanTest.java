package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.pojo.Teacher;

public class FactoryBeanTest {

	@Test
	public void testFactoryBean() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
		Teacher teacher = ioc.getBean(Teacher.class);
		System.out.println(teacher);
		ioc.close();
	}
}
