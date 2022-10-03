package cardstore.utils;



import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	public static SqlSession getSqlSession() {
		SqlSession sqlSession =null;
		//獲取核心文件
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//獲取SqlSessionFactoryBuilder對象
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//獲取SqlSessionFactory對象
			SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(is);
			//獲取sql會話對象SqlSession Mybatis提供的資料庫操作對象並自動commit
			sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
