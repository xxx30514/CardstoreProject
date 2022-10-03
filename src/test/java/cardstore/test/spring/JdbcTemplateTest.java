package cardstore.test.spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cardstore.pojo.Emp;
//指定當前測試類在spring環境中執行 (junit4) 透過注入方式直接獲取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith junit5
//設置spring測試環境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testInsert() {
		//增刪改都用update方法 sql語句不同
		String sql = "insert into t_emp values(null,?,?,?,?)";
		jdbcTemplate.update(sql,"老五",30,"男",1);
	}
	
	@Test
	public void testQuery() {
		//查詢單筆資料的方法
		String sql = "select * from t_emp where emp_id = ?";
		Emp emp = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Emp.class),35);
		System.out.println(emp);
	}
	
	@Test
	public void testGetAllEmp() {
		//查詢多筆資料的方法
		String sql = "select * from t_emp";
		List<Emp> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Emp.class));
		list.forEach(System.out::println);
	}
	
	@Test
	public void testGetCount() {
		//查詢特殊值(資料數)
		String sql = "select count(*) from t_emp";
		Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
		System.out.println(count);
	}
}
