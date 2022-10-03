package cardstore.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


//處理bean初始化前後執行的方法
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	//初始化前
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor-->postProcessBeforeInitialization");
		return bean;
	}
	@Override
	//初始化後
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor-->postProcessAfterInitialization");
		return bean;
	}
}
