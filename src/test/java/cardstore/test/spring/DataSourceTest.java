package cardstore.test.spring;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {

	
	@Test
	public void testDatasource() throws SQLException {
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
		BasicDataSource dataSource = ioc.getBean(BasicDataSource.class);
		System.out.println(dataSource.getConnection());
		ioc.close();
		
	}
}
