package advancedWEB.DICE.Controller.DispatcherCont.View;

import advancedWEB.DICE.Domain.Search.SearchResult;
import advancedWEB.DICE.Domain.View.AboutView;
import advancedWEB.DICE.Service.Search.SearchService;
import advancedWEB.DICE.Service.View.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ViewController {

    @Autowired
    ViewService viewService;

    @RequestMapping(value="/About", method = RequestMethod.GET)
    public ModelAndView about(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        String ID = request.getParameter("ID");

        AboutView aboutView = new AboutView();

        if(ID == null || ID == "") {
            mv.setViewName("ErrorControl/404");
            return mv;
        }

        aboutView = viewService.AboutViewByID(ID);

        if(aboutView == null) {
            mv.setViewName("ErrorControl/404");
            return mv;
        }

        mv.setViewName("View/About");
        mv.addObject("aboutView",aboutView);
        return mv;
    }
}
