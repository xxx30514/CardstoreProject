package cardstore.test.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cardstore.mapper.Emp2Mapper;
import cardstore.pojo.Emp2;
import cardstore.utils.SqlSessionUtil;

public class PageTest {
	//pageNum:當前頁碼 pageSize:每頁顯示條數 size:當前頁面顯示的實際條數 total:資料總筆數 pages:總頁數
	@Test
	public void testPage() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		Emp2Mapper mapper = sqlSession.getMapper(Emp2Mapper.class);
		//查詢前 開啟分頁功能
		Page<Object> page = PageHelper.startPage(1, 4);
		List<Emp2> list = mapper.selectByExample(null);
		//查詢後 獲取分頁相關資料
		PageInfo<Emp2> pageInfo =new PageInfo<>(list,5);
		list.forEach(System.out::println);
		System.out.println(page);
		System.out.println(pageInfo);
		int pages = pageInfo.getPages();
		long total = pageInfo.getTotal();
		System.out.println(pages);
		System.out.println(total);
		
	}
}
