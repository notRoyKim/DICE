package advancedWEB.DICE.Service.Data;

import advancedWEB.DICE.Domain.Data.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {

    @Select("SELECT Category FROM Category WHERE Board_ID = ${ID};")
    String IDCategory(String ID);

    @Select("SELECT * FROM CategoryView ORDER BY Rate DESC LIMIT ${Page}, ${NumPage};")
    List<Category> CategoryWithLimit(int Page, int NumPage);
}
