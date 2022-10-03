package cardstore.mapper;

import cardstore.pojo.Cart;
import cardstore.pojo.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart row);

    int insertSelective(Cart row);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByExampleSelective(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByExample(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart row);

    int updateByPrimaryKey(Cart row);
}