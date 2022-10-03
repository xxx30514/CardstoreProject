package cardstore.service;

public interface CheckoutService {
	//結帳
	void checkout(Integer userId, Integer[] bookIds);

}
