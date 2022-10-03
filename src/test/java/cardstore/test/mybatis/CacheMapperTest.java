package cardstore.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import cardstore.mapper.CacheMapper;
import cardstore.pojo.Emp;
import cardstore.utils.SqlSessionUtil;

public class CacheMapperTest {
	/**
	 * Mybatis的一級快取:
	 *  SqlSession級別: 同一個SqlSession查詢的同一筆資料會從快取中取出 不會查詢兩次
	 *  一級快取預設為開啟狀態
	 *  一級快取失效的四種情況
	 *  1.使用不同的SqlSession 2.查詢條件不同 3.兩次查詢間執行過增刪改 4.兩次查詢間手動清除快取
	 *  Mybatis的二級快取:
	 *  SqlSessionFactory級別: 同一個SqlSessionFactory查詢的同一筆資料會從快取中取出 不會查詢兩次
	 *  Mybatis二級快取開啟條件:
	 *  1.核心配置文件設置cacheEnabled="true" 預設已為true 不用配置
	 *  2.映射文件設置標籤<cache/> CachMapper.xml
	 *  3.二級快取要在SqlSession關閉或提交後生效
	 *  3.查詢資料轉換成的實體類必須實現序列化
	 */
	@Test
	public void testGetEmpByEmpId(){
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
		Emp emp1 = mapper.getEmpByEmpId(1);
		System.out.println(emp1);
		Emp emp2 = mapper.getEmpByEmpId(1);
		System.out.println(emp2);
		SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
		CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
		Emp emp3 = mapper2.getEmpByEmpId(1);
		System.out.println(emp3);
	}
	
	@Test
	public void testCache() throws IOException{
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
		CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
		Emp emp1 = mapper1.getEmpByEmpId(1);
		System.out.println(emp1);
		sqlSession1.close();
		SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
		CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
		Emp emp2 = mapper2.getEmpByEmpId(1);
		System.out.println(emp2);
		sqlSession2.close();
	}
}
