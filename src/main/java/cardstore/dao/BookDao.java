package cardstore.dao;

public interface BookDao {
	//根據圖書ID查圖書價格
	Integer getPriceByBookId(Integer bookId);
	//更新圖書庫存
	void updateStock(Integer bookId);
	//更新買家餘額
	void updateBalance(Integer userId, Integer price);

}
