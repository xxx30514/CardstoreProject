package cardstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cardstore.dao.BookDao;
import cardstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional(
				/*readOnly = true 僅能在全部都是查詢操作時才能使用
				 * timeout = -1 (預設值):無等待時間 timeout = 10 :等待10秒 10秒內事務沒有執行完 強制回滾並丟擲異常 
				 * norollbackFor:不因...回滾 norollbackFor = {ArithmeticException.class} :不因數學運算異常回滾
				 * norollbackForClassName:不因...回滾 norollbackForClassName = "java.lang.ArithmeticException"
				 * 事務隔離級別  isolation = Isolation.DEFAULT 基本上都使用資料庫預設隔離級別
				 * 事件傳播propagation = Propagation.REQUIRED(預設值) 使用調用者事務 結帳方法調用買書方法 使用結帳事務 異常=回滾結帳
				 * propagation = Propagation.REQUIRES_NEW 另外開啟新事務  使用被調用的方法的事務=使用買書事務 
				 * 回滾買書事務 買第一本 提交一次 買第二本失敗 回滾=>買到一本
				*/	
			)
	public void buyBook(Integer userId, Integer bookId) {
		//查詢圖書價格
		Integer price = bookDao.getPriceByBookId(bookId);
		//更新圖書庫存
		bookDao.updateStock(bookId);
		//更新購買者帳戶餘額
		bookDao.updateBalance(userId, price);
	}

}
