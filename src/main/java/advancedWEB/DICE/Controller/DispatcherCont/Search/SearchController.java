package advancedWEB.DICE.Controller.DispatcherCont.Search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SearchController {
    @RequestMapping(value="/SearchResult", method = RequestMethod.GET)
    public ModelAndView searchresult(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        String query = request.getParameter("query");

        if(query == null || query == "") {
            mv.setViewName("ErrorControl/404");
            return mv;
        }
        else if(query.length() < 2) {
            mv.setViewName("ErrorControl/404");
            return mv;
        }

        mv.setViewName("Search/SearchResult");
        mv.addObject("query",query);
        return mv;
    }
}
