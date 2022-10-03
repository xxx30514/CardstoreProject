package cardstore.aop_annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//設置優先級@Order(int) 數字越小優先級越高
@Order(1)
public class VaildateAspect {
	

	@Before("cardstore.aop_annotation.LoggerAspect.pointCut()")
	public void beforeMethod() {
		System.out.println("VaildateAspect-->前置通知");
	}
}
