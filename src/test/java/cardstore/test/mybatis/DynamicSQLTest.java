package cardstore.test.mybatis;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import cardstore.mapper.DynamicSQLMapper;
import cardstore.pojo.Emp;
import cardstore.utils.SqlSessionUtil;

public class DynamicSQLTest {
	
	@Test
	public void testGetEmpByCondition() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper =sqlSession.getMapper(DynamicSQLMapper.class);
		Emp emp = new Emp(null,"張三",20,"男");
		List<Emp> list = mapper.getEmpByCondition(emp);
		list.forEach(System.out::println);
		
	}	
	
	@Test
	public void testGetEmpByChoose() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper =sqlSession.getMapper(DynamicSQLMapper.class);
		Emp emp = new Emp(null,"張三",20,"男");
		List<Emp> list = mapper.getEmpByChoose(emp);
		list.forEach(System.out::println);
		
	}	
	
	@Test
	public void testInsertMoerEmp() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper =sqlSession.getMapper(DynamicSQLMapper.class);
		Emp emp = new Emp(null,"小明",20,"男");
		Emp emp1 = new Emp(null,"小王",20,"男");
		Emp emp2 = new Emp(null,"小吳",20,"男");
		List<Emp> list = Arrays.asList(emp,emp1,emp2);
		mapper.insertMoerEmp(list);
	}
	
	@Test
	public void testDeleteMoerEmp() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper =sqlSession.getMapper(DynamicSQLMapper.class);
		Integer[] empIds= new Integer[]{5,6}; 
		mapper.deleteMoerEmp(empIds);
	}	
}
