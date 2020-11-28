package advancedWEB.DICE.Controller.DoCont;

import advancedWEB.DICE.Domain.Search.SearchResult;
import advancedWEB.DICE.Service.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchJSONController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/Search_JSON", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchJSON(HttpServletRequest request) {

        Map<String, Object> search_result = new HashMap<>();

        String searchWord = request.getParameter("query");

        String Page = request.getParameter("Page");
        String NumPage = request.getParameter("NumPage");

        List<SearchResult> result_list = new ArrayList<>();

        //JSON 전체 검색
        if(Page == null | NumPage == null) {
            result_list = searchService.SearchBoardAll(searchWord);
        }
        //Limit를 가지고 검색
        else if (Page != null & NumPage != null) {
            result_list = searchService.SearchBoardAllWithLimit(searchWord, Integer.parseInt(Page), Integer.parseInt(NumPage));
        }

        search_result.put("SearchResult",result_list);
        search_result.put("Count",result_list.size());

        return  search_result;
    }
}
