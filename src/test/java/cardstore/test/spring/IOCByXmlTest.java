package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cardstore.pojo.Emp;

public class IOCByXmlTest {
	/*在滿足bean唯一性的前提下
	 * 透過bean的類 bean繼承的類 bean介面的實現類(impl)都可以獲取bean
	 * 常利用impl獲取bean
	 * */
	@Test
	public void testIOC() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
		// Emp emp1 = (Emp) ioc.getBean("emp1"); 根據ID獲取 要強轉
		//bean的無參數建構子是必要的 透過無參數建構子映射賦值
		Emp emp1 = ioc.getBean(Emp.class); //根據類獲取 最常使用 僅能有一個符合的bean存在
		//Emp bean = ioc.getBean("emp1", Emp.class); 根據ID 與類獲取bean 針對同一個類不同ID 基本上一個bean僅會配對一個id 不常使用
		System.out.println(emp1);
		ioc.close();
		
	}
	
	//依賴注入:為類中的屬性賦值的過程
	//利用setter(set方法)或是有參數建構子賦值
	//set注入:透過成員變數的set方法賦值 較常使用
	@Test
	public void testDI() {
		//獲取ioc容器
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
		//獲取bean
		Emp emp1 = ioc.getBean("emp1", Emp.class); 
		Emp emp2 = ioc.getBean("emp2", Emp.class); 
		Emp emp3 = ioc.getBean("emp3", Emp.class); 
		Emp emp4 = ioc.getBean("emp4", Emp.class); 
		Emp emp5 = ioc.getBean("emp5", Emp.class); 
		System.out.println("emp1:"+emp1);
		System.out.println("emp2:"+emp2);
		System.out.println("emp3:"+emp3);
		System.out.println("emp4:"+emp4);
		System.out.println("emp5:"+emp5);
		ioc.close();
		
	}	
}
