package advancedWEB.DICE.Service.Search;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SearchMapper {
    //전체 검색
    @Select("SELECT ID FROM BoardInfo WHERE Title LIKE '%${SearchWord}%'")
    List<String> SearchBoardID(String SearchWord);
}
