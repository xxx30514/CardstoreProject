package cardstore.aop_annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * 1.在切面中必須透過指定註解將方法標示為通知方法
 * 1-1.@Before:前置通知:目標對象方法執行前執行
 * 1-2.@After:在目標對象方法的finally子句中執行(碰到異常還是會執行)
 * 1-3.@AfterReturning:返回通知 在目標方法返回值後執行(碰到異常不處理 獲取不到返回值) (try子句)
 * 1-4.@AfterThrowing:異常通知 在目標方法的catch子句中執行(有異常執行)
 * 2.切入點表達式:設置在通知的註解的Value中
 * ("execution(public int cardstore.aop_annotation.CalculatorPureImpl.add(int, int))")
 * ("execution(* cardstore.aop_annotation.*.*(..))")
 * 第一個*表示返回任意修飾符與返回值類型 
 * 第二個*表示cardstore.aop_annotation下的所有類 
 * 第三個*表示類中的任一方法
 * ..表示任意的參數列表
 * 
 * 3.重用切入點表達式
	@Pointcut("execution(* cardstore.aop_annotation.*.*(..))")
	public void pointCut() {}
	使用方式
	@Before("pointCut()")   (方法名)
 * 
 * 4.獲取連接點資訊
 * 在通知方法的參數中設置JoinPoint類型的參數 就可以獲取連接點對應的方法資訊
 * 
 * 5.切面優先級
 * 設置優先級@Order(int) 預設值為Integer的最大值 數字越小優先級越高 @Order(1) > @Order(2)
 * */
@Component
@Aspect //將當前組件標示為切面類 
public class LoggerAspect {
	
	@Pointcut("execution(* cardstore.aop_annotation.*.*(..))")
	public void pointCut() {
		
	}
	
	//@Before("execution(public int cardstore.aop_annotation.CalculatorPureImpl.add(int, int))")
	//@Before("execution(* cardstore.aop_annotation.*.*(..))")
	@Before("pointCut()")
	public void beforeAdviceMethod(JoinPoint joinPoint) {
		//獲取連接點對應的詳細資訊 signature.getName():獲取方法名
		Signature signature = joinPoint.getSignature();
		//獲取連接點對應方法的參數
		Object[] args = joinPoint.getArgs();
		System.out.println("LoggerAspect, 方法:"+signature.getName()+", 參數:"+Arrays.toString(args));
	}
	
	@After("pointCut()")
	public void afterAdviceMethod(JoinPoint joinPoint) {
		//獲取連接點對應的詳細資訊 
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, 方法:"+signature.getName()+", 執行完畢");
	}
	
	/*若要在返回通知中獲取目標對象方法的返回值 
	 *只需要通過@AfterReturning註解的returning屬性 
	 *就可以將通知方法的某個參數指定為接收目標對象方法的返回值參數
	 */
	@AfterReturning(value = "pointCut()", returning = "result")
	public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, 方法:"+signature.getName()+", 結果:"+ result);
	}
	
	/*若要在返回通知中獲取目標對象方法的異常
	 *只需要通過@AfterThrowing註解的throwing屬性 
	 *就可以將通知方法的某個參數指定為接收目標對象方法的異常參數
	 */
	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable exception) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, 方法:"+signature.getName()+", 異常:"+exception);
	}
	
	@Around("pointCut()")
	//環繞通知方法的返回值一定要和目標對象方法返回值一致
	public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
		Object result = null;
		Signature signature = joinPoint.getSignature();
		Object[] args = joinPoint.getArgs();
		//表示目標對象方法的執行
		try {
			System.out.println("環繞通知---前置");
			System.out.println("LoggerAspect, 方法名稱:"+signature.getName()+", 參數:"+Arrays.toString(args));
			result = joinPoint.proceed();
			System.out.println("環繞通知---返回");
		} catch (Throwable e) {	
			e.printStackTrace();
			System.out.println("環繞通知---異常");
		} finally {
			System.out.println("環繞通知---後置");
		}
		return result;
	}
}
