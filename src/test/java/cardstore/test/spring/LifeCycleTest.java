package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.pojo.Teacher;

public class LifeCycleTest {
	/*生命周期
	 * 1.實例化
	 * 2.依賴注入
	 * 3.後置處理器初始化前 BeanPostProcessor
	 * 4.初始化 指定初始化方法init-method="initMethod"
	 * 5.後置處理器初始化後 BeanPostProcessor
	 * 6.銷毀:IOC容器關閉時銷毀  指定銷毀方法destroy-method="destroyMethod" 
	 * 注意:若bean作用域為單例時 1.實例化2.依賴注入3.初始化 在獲取IOC容器時執行
	 * 注意:若bean作用域為多例時 1.實例化2.依賴注入3.初始化 在獲取bean時執行 銷毀也不由ioc管理
	*/
	
	
	@Test
	public void testLifeCycle() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
		Teacher teacher = ioc.getBean(Teacher.class);
		System.out.println(teacher);
		ioc.close();
	}
}
