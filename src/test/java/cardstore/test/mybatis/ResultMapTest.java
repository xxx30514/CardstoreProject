package cardstore.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import cardstore.mapper.DeptMapper;
import cardstore.mapper.EmpMapper;
import cardstore.pojo.Dept;
import cardstore.pojo.Emp;
import cardstore.utils.SqlSessionUtil;

public class ResultMapTest {
	
	@Test
	public void testGetEmpByEmpId() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp = mapper.getEmpByEmpId(2);
		System.out.println(emp);
	}
	@Test
	public void testGetEmpAndDeptByEmpId() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp = mapper.getEmpAndDeptByEmpId(1);
		System.out.println(emp);
	}
	@Test
	public void testGetEmpAndDeptByStep() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp = mapper.getEmpAndDeptByStep(1);
		System.out.println(emp);
	}
	@Test
	public void testGetDeptAndEmpByDeptId() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept = mapper.getDeptAndEmpByDeptId(1);
		System.out.println(dept);
	}
	
	@Test
	public void testGetDeptAndEmpByStep() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept = mapper.getDeptAndEmpByStepOne(1);
		System.out.println(dept);
	}
}
