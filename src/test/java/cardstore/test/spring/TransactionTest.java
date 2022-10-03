package cardstore.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cardstore.practice.BookController;
/*宣告式事務配置步驟
 * 1.在spring配置文件配置事務管理器
 * 2.開啟事務的註解驅動
 * 3.在需要被事務管理的方法上加上@Transactional 該方法就會被事務管理
 * @Transactional也可以加在類上 代表該類中的所有方法都會被事務管理
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class TransactionTest {
	
	@Autowired
	private BookController bookController;
	
	@Test
	public void testBuyBook() {
		bookController.buyBook(1, 1);
	}
	@Test
	public void testCheckout() {
		bookController.checkout(1, new Integer[] {1,2});
	}
}
