package cardstore.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cardstore.service.BookService;
import cardstore.service.CheckoutService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CheckoutService checkoutService;
	
	public void buyBook(Integer userId,Integer bookId) {
		bookService.buyBook(userId,bookId);
	}
	//買多本書
	public void checkout(Integer userId,Integer[] bookIds) {
		checkoutService.checkout(userId,bookIds);
	}
}
