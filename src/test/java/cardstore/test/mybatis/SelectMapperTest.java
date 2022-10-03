package cardstore.test.mybatis;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import cardstore.mapper.SelectMapper;
import cardstore.pojo.User;
import cardstore.utils.SqlSessionUtil;

public class SelectMapperTest {
	
	@Test
	public void testGetUserById() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);
		sqlSession.close();	
	}
	@Test
	public void testGetAllUser() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		List<User> list = mapper.getAllUser();
		list.forEach(System.out::println);
		sqlSession.close();	
	}
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		Integer count = mapper.getUserCount();
		System.out.println("共有"+count+"位使用者");
		sqlSession.close();	
	}
	@Test
	public void testGetUserByIdToMap() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		Map<String, Object> map = mapper.getUserByIdToMap(1);
		//{u_name=管理員, u_id=1, u_nickname=店長, u_email=xxx30514@gmail.com, u_account=admin, u_password=admin, u_status=1}
		//null的值不會放進map
		System.out.println(map);
		sqlSession.close();	
	}
	@Test
	public void testGetAllUserToMap() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		//List<Map<String, Object>> list = mapper.getAllUserToMap();
		//System.out.println(list);
		Map<String, Object> map =mapper.getAllUserToMap();
		//{1={u_name=管理員, u_id=1, u_nickname=店長, u_email=xxx30514@gmail.com, u_account=admin, u_password=admin, u_status=1}
		//, 2={u_name=店員, u_id=2, u_nickname=店員, u_email=123@gmail.com, u_date=2022-09-05T16:54:14, u_account=xxx30514, u_password=a091265887, u_status=0}}
		System.out.println(map);
		sqlSession.close();	
	}
	@Test
	public void testSearchUser() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		List<User> list = mapper.SearchUser("管");
		list.forEach(System.out::println);
		sqlSession.close();	
	}
	@Test
	public void testgetUserList() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		List<User> list = mapper.getUserList("t_user");
		list.forEach(System.out::println);
		sqlSession.close();	
	}
	@Test
	public void testInsertUser() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
		User user = new User(null,"xxx1", "a091265887", "店員", "店員", "12345@gmail.com",LocalDateTime.now(), 0);
		mapper.insertUser(user);
		System.out.println(user);
		sqlSession.close();	
	}
}
