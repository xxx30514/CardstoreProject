package cardstore.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import cardstore.mapper.UserMapper;
import cardstore.pojo.User;
import cardstore.utils.SqlSessionUtil;

public class MybatisTest {
	@Test	
	public void testInsert() throws IOException {
		//獲取核心文件
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//獲取SqlSessionFactoryBuilder對象
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//獲取SqlSessionFactory對象
		SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(is);
		//獲取sql會話對象SqlSession Mybatis提供的資料庫操作對象 不會自動commit
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		//獲取sql會話對象SqlSession Mybatis提供的資料庫操作對象 會自動commit
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//獲取UserMapper代理實作對象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//調用mapper介面中的方法 實現新增功能
		User user = new User(null,"xxx30514", "a091265887", "店員", "店員", "123@gmail.com",LocalDateTime.now(), 0);
		mapper.insertUser(user);
		//int result =sqlSession.insert("cardstore.mapper.UserMapper.insertUser");
		System.out.println("結果:"+user);
		//提交
		//sqlSession.commit();
		//關閉sqlsession
		sqlSession.close();
	}
	@Test
	public void testUpdate() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.updateUser();
		sqlSession.close();
	}
	@Test
	public void testDelete() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.deleteUser();
		sqlSession.close();
	}
	@Test
	public void testGetUserById() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(2);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testGetAllUser() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.getAllUser();
		list.forEach(System.out::println);
		sqlSession.close();
	}
	@Test
	public void testGetUserByAccount() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserByAccount("admin");
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testCheckLogin() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.checkLogin("admin", "admin");
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testCheckLoginByMap() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//自定鍵值
		Map<String, Object> map =new HashMap<>();
		map.put("account", "admin");
		map.put("password", "admin");
		User user = mapper.checkLoginByMap(map);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testCheckLoginByParam() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.checkLoginByParam("admin", "admin");
		System.out.println(user);
		sqlSession.close();
	}
}
