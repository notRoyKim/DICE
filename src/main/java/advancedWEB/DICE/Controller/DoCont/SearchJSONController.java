package advancedWEB.DICE.Controller.DoCont;

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

        List<String> result_list = searchService.SearchBoardID(searchWord);

        search_result.put("Search_result",result_list);
        search_result.put("Count",result_list.size());

        return  search_result;
    }
}
