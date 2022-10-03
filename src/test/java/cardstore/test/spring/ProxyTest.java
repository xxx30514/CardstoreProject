package cardstore.test.spring;

import org.junit.jupiter.api.Test;

import cardstore.proxy.Calculator;
import cardstore.proxy.CalculatorPureImpl;
import cardstore.proxy.CalculatorStaticProxy;
import cardstore.proxy.ProxyFactory;

public class ProxyTest {
	/*動態代理
	 * 1.jdk動態代理 , 要求必須有介面,最終生成的代理類與目標類實作相同介面,在com.sun.proxy package下 , 類名為$proxy+數字
	 * 2.cglib動態代理 , 最終生成的代理類會繼承目標類 , 並且在目標類在相同package下
	*/
	
	//靜態代理實現
	@Test
	public void testProxy() {
		CalculatorStaticProxy proxy =new CalculatorStaticProxy(new CalculatorPureImpl());
		proxy.add(1, 2);
	}
	
	//動態代理實現
	@Test
	public void testDynamicProxy() {
		ProxyFactory proxyFactory = new ProxyFactory(new CalculatorPureImpl());
		Calculator proxy = (Calculator) proxyFactory.getProxy();
		proxy.add(1, 2);
	}
}
