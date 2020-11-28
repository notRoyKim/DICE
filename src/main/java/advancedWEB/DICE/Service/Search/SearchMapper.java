package advancedWEB.DICE.Service.Search;

import advancedWEB.DICE.Domain.Search.SearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SearchMapper {
    //전체 검색
    @Select("SELECT ID FROM BoardInfo WHERE Title LIKE '%${SearchWord}%';")
    List<String> SearchBoardID(String SearchWord);
    @Select("SELECT ID FROM BoardInfo WHERE Title LIKE '%${SearchWord}%' LIMIT ${Page}, ${NumPage};")
    List<String> SearchBoardIDWithLimit(String SearchWord, int Page, int NumPage);

    @Select("SELECT * FROM SearchResultView WHERE ID = '${ID}';")
    SearchResult SearchView(String ID);
    @Select("SELECT * FROM SearchResultView WHERE ID = '${ID}' LIMIT ${Page}, ${NumPage};")
    SearchResult SearchViewWithLimit(String ID, int Page, int NumPage);
}
