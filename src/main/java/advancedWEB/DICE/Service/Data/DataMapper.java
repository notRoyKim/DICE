package advancedWEB.DICE.Service.Data;

import advancedWEB.DICE.Domain.Data.Category;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("INSERT INTO BoardInfo (Title, Context, Price, Difficulty, Headcount, Age, Playtime) VALUE( '${title}', '${context}', '${price}', '${difficulty}', '${headcount}', '${age}', '${time}');")
    void setData(Map<String, String> sqlParam);

    @Insert("INSERT INTO ImageFiles (Board_ID, Files) VALUE ((SELECT ID from BoardInfo WHERE Title='${title}') ,'${image}');")
    void setImage(Map<String, String> sqlParam);

    @Insert("INSERT INTO Category (Board_ID, Category) VALUE ((SELECT ID from BoardInfo WHERE Title='${title}') ,'${category}');")
    void setCategory(Map<String, String> sqlParam);

    @Insert("INSERT INTO Rating (Board_ID, Rate, Ratecount) VALUE ((SELECT ID from BoardInfo WHERE Title='${title}'), 0, 0);")
    void setRating(Map<String, String> sqlParam);

    @Insert("Insert INTO Rules (Board_ID, Files) VALUE ((SELECT ID from BoardInfo WHERE Title='${title}'), '${rules}');")
    void setRules(Map<String, String> sqlParam);

    @Select("SELECT Rate, RateCount FROM Rating WHERE Board_ID = ${ID};")
    Rating getRateID(String ID);
}
