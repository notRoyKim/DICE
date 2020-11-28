package advancedWEB.DICE.Controller.DispatcherCont.Search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {
    @RequestMapping(value="/SearchResult", method = RequestMethod.GET)
    public ModelAndView searchresult(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Search/SearchResult");

        return mv;
    }
}
