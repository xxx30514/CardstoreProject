package cardstore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//動態代理
public class ProxyFactory {

	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxy() {
		/*
		 * ClassLoader loader: 指定載入動態生成代理類的類別載入器 Class[] interfaces:
		 * 獲取目標對象實作類的所有介面的class物件陣列Class[] 
		 * InvocationHandler h: 設置代理類中的抽象方法如何重寫
		 */
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// proxy:代理對象(目標),method:要執行的方法,args:要執行方法的參數列表
				Object result = null;
				try {
					System.out.println("log , 方法:" + method.getName() + ",參數:" + Arrays.toString(args));
					result = method.invoke(target, args);
					System.out.println("log , 方法:" + method.getName() + ",結果:" + result);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("log , 方法:" + method.getName() + ",異常:" + e);
				} finally {
					System.out.println("log , 方法:" + method.getName() + ",方法執行完畢");
				}
				return result;
			}
		};
		return Proxy.newProxyInstance(classLoader, interfaces, h);
	}
}
