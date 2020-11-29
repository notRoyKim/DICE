package advancedWEB.DICE.Service.Search;

import advancedWEB.DICE.Domain.Search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchMapper searchMapper;

    //ID만 찾기
    public List<String> SearchBoardID(String SearchWord) {
        return searchMapper.SearchBoardID(SearchWord);
    }
    //검색 전체 기능
    public List<SearchResult> SearchBoardAll(String SearchWord) {

        List<String> result_ID = searchMapper.SearchBoardID(SearchWord);

        List<SearchResult> SearchResultList = new ArrayList<>();

        for(int i = 0; i < result_ID.size(); i++) {
            SearchResult TempResult = searchMapper.SearchView(result_ID.get(i));
            String TempFilePath = TempResult.getFiles();
            TempFilePath = "http://15.164.232.90/Images/" + TempFilePath;
            TempResult.setFiles(TempFilePath);
            SearchResultList.add(TempResult);
        }

        return SearchResultList;
    }
    //검색 기능
    public List<SearchResult> SearchBoardAllWithLimit(String SearchWord, int Page, int NumPage) {

        List<String> result_ID = searchMapper.SearchBoardIDWithLimit(SearchWord, Page * NumPage, NumPage);

        List<SearchResult> SearchResultList = new ArrayList<>();

        for(int i = 0; i < result_ID.size(); i++) {
            SearchResult TempResult = searchMapper.SearchViewWithLimit(result_ID.get(i), Page * NumPage, NumPage);
            String TempFilePath = TempResult.getFiles();
            TempFilePath = "http://15.164.232.90/Images/" + TempFilePath;
            TempResult.setFiles(TempFilePath);
            SearchResultList.add(TempResult);
        }

        return SearchResultList;
    }
}
