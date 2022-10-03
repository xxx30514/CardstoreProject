package cardstore.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cardstore.practice.TestController;
import cardstore.dao.TestDao;
import cardstore.service.TestService;

/*@Controller:控制層組件
 *@Service:業務邏輯層組件
 *@Repository:持久層組件
 *@Component:一般組件
 *上述組件標籤功能一致,僅是供開發人員方便辨識
 *透過註解+掃描的beanid 預設值為類的小駝峰 即類名首字母為小寫的結果 TestController id=testController
 *自訂id:透過組件註解的value屬性設置 @Controller("controller1") id=controller1
 *@Autowired 實現自動配置 3種方式擇一即可
 *1.**常用可標示在成員變數上,此時不需要設置成員變數的set方法
 *2.可標示在set方法上
 *3.為當前成員變數賦值的有參數建構子上
 *預設是以byType方式配置 若byType不成功則會自動改用byName方式配置
 *若byType與byName皆無法自動配置 即IOC容器中有多個符合的bean且id與要賦值的屬性名都不一致
 *可在要賦值的屬性上@Qualifier("")通過該註解的value屬性 指定baen的id 將這個bean為屬性賦值
 *要@Qualifier使用的狀況很少
 *IOC容器中沒有任何符合的bean=>NoSuchBeanDefinition
 *特例:@Autowired中有屬性required 預設值true 必須完成自動配置
 *可將required屬性改為false 能自動配置就自動配置 不能就使用屬性預設值(不配置)
*/
public class IOCByAnnotationTest {
	
	@Test
	public void testAutowireAnnotation() {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-annotation.xml");
		TestController testController = ioc.getBean(TestController.class);
		testController.saveTest();
		System.out.println(testController);
		TestService testService = ioc.getBean(TestService.class);
		System.out.println(testService);
		TestDao testDao = ioc.getBean(TestDao.class);
		System.out.println(testDao);
		ioc.close();
	}
	
	
}
