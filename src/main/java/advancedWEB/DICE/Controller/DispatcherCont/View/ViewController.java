package advancedWEB.DICE.Controller.DispatcherCont.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
    @RequestMapping(value="/About", method = RequestMethod.GET)
    public ModelAndView about(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("View/About");

        return mv;
    }
}
