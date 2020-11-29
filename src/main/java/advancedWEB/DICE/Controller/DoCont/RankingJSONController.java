package advancedWEB.DICE.Controller.DoCont;

import advancedWEB.DICE.Domain.Data.Category;
import advancedWEB.DICE.Domain.Search.SearchResult;
import advancedWEB.DICE.Service.Data.DataService;
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
public class RankingJSONController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/Ranking_JSON", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchJSON(HttpServletRequest request) {
        Map<String, Object> search_result = new HashMap<>();

        String Page = request.getParameter("Page");
        String NumPage = request.getParameter("NumPage");

        List<Category> result_list = new ArrayList<>();

        //Limit를 가지고 검색
        if (Page != null & NumPage != null) {
            result_list = dataService.RankingAllWithLimit(Integer.parseInt(Page), Integer.parseInt(NumPage));
        }

        search_result.put("RankingResult",result_list);
        search_result.put("Count",result_list.size());

        return  search_result;
    }
}
