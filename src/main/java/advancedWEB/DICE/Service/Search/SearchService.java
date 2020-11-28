package advancedWEB.DICE.Service.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchMapper searchMapper;

    public List<String> SearchBoardID(String SearchWord) {
        return searchMapper.SearchBoardID(SearchWord);
    }
}
