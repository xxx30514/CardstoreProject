package cardstore.mapper;

import cardstore.pojo.Buyer;
import cardstore.pojo.BuyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyerMapper {
    long countByExample(BuyerExample example);

    int deleteByExample(BuyerExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Buyer row);

    int insertSelective(Buyer row);

    List<Buyer> selectByExample(BuyerExample example);

    Buyer selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("row") Buyer row, @Param("example") BuyerExample example);

    int updateByExample(@Param("row") Buyer row, @Param("example") BuyerExample example);

    int updateByPrimaryKeySelective(Buyer row);

    int updateByPrimaryKey(Buyer row);
}