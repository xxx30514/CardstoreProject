package cardstore.mapper;

import cardstore.pojo.Emp2;
import cardstore.pojo.Emp2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Emp2Mapper {
    long countByExample(Emp2Example example);

    int deleteByExample(Emp2Example example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Emp2 row);

    int insertSelective(Emp2 row);

    List<Emp2> selectByExample(Emp2Example example);

    Emp2 selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("row") Emp2 row, @Param("example") Emp2Example example);

    int updateByExample(@Param("row") Emp2 row, @Param("example") Emp2Example example);

    int updateByPrimaryKeySelective(Emp2 row);

    int updateByPrimaryKey(Emp2 row);
}