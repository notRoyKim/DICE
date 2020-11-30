package advancedWEB.DICE.Service.Data;

import advancedWEB.DICE.Domain.Data.Category;
import advancedWEB.DICE.Domain.Data.Rating;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper {

    @Select("SELECT Category FROM Category WHERE Board_ID = ${ID};")
    String IDCategory(String ID);

    @Select("SELECT * FROM CategoryView ORDER BY Rate DESC LIMIT ${Page}, ${NumPage};")
    List<Category> CategoryWithLimit(int Page, int NumPage);

    @Select("SELECT Rate, RateCount FROM Rating WHERE Board_ID = ${ID};")
    Rating getRateID(String ID);
}
