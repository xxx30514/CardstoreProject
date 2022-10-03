package cardstore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cardstore.pojo.User;

public interface SelectMapper {
	//根據ID查詢使用者資料(一筆)
	//多筆資料不能用實體類(User)作返回值 會有TooManyResultException
	User getUserById(@Param("id")Integer id);
		
	//查詢所有使用者 多筆或單筆資料都可以用List集合類型作返回值
	List<User> getAllUser();
	
	//查詢使用者數量
	Integer getUserCount();
	
	//根據ID查詢使用者資訊的map集合
	Map<String, Object> getUserByIdToMap(@Param("id")Integer id);
	//查詢所有使用者 map放入集合 查詢的資料有多筆時 並將每條資料轉換成map集合
	//****1.List<Map<String, Object>> getAllUserToMap();將返回值設為泛型為map的List集合 (較常使用)
	//2.將每筆資料轉換的map集合中放在一個大的map中 透過@MapKey("u_id") 將查詢的某個欄位名稱的值作為key
	@MapKey("u_id")
	Map<String, Object> getAllUserToMap();
	//
	List<User> SearchUser(@Param("keyword")String keyword);
	//動態設置表格名
	List<User> getUserList(@Param("tableName")String tableName);
	
	//新增使用者 並獲取自增主鍵
	void insertUser(User user);
}
