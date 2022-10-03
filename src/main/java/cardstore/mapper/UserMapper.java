package cardstore.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cardstore.pojo.User;

public interface UserMapper {
	//新增使用者
	void insertUser(User user);
	//修改使用者資料
	void updateUser();
	//刪除使用者資料
	void deleteUser();
	//批量刪除
	void deleteUsers(@Param("ids")String ids);
	//根據ID查詢使用者資料(一筆)
	User getUserById(@Param("id")Integer id);
	//查詢所有使用者
	List<User> getAllUser();
	//根據帳號查詢使用者資料 驗證是否已有重複帳號名稱
	User getUserByAccount(String account);
	//登入驗證
	User checkLogin(String account,String password);
	User checkLoginByMap(Map<String, Object> map);
	User checkLoginByParam(@Param("account") String account,@Param("password") String password);
}
