package advancedWEB.DICE.Controller.DoCont;

import advancedWEB.DICE.Service.Data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RateAJAXController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/Rate_JSON", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> RateJSON(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        String ID = request.getParameter("ID");
        String Rate = request.getParameter("Rate");

        dataService.setRate(ID,Float.parseFloat(Rate));

        return map;
    }
}