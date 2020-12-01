package advancedWEB.DICE.Controller.DoCont;


import advancedWEB.DICE.Service.Data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/admin");
        String path = "/var/www/html/Images/";
        try {
            String title = request.getParameter("title");
            String context = request.getParameter("context");
            String category = request.getParameter("genre");
            String age = request.getParameter("age");
            String headcount = request.getParameter("headcount");
            String difficulty = request.getParameter("difficulty");
            String time = request.getParameter("time");
            String price = request.getParameter("price");
            MultipartFile image = request.getFile("img");
            MultipartFile[] images = new MultipartFile[4];
            images[0] = request.getFile("img1");
            images[1] = request.getFile("img2");
            images[2] = request.getFile("img3");
            images[3] = request.getFile("img4");

            Map<String, String> sqlParam = new HashMap<>();

            File file = new File(path + image.getOriginalFilename());
            image.transferTo(file);
            String rules = "";
            for (MultipartFile f : images) {
                if (!f.getOriginalFilename().equals("")) {
                    File detailFile = new File(path + f.getOriginalFilename());
                    f.transferTo(detailFile);
                    rules += f.getOriginalFilename() + ",";
                }
            }

            if (!rules.equals("")) {
                rules = rules.substring(0, rules.length() - 1);
            }

            Map<String, String> imageSqlParam = new HashMap<>();
            imageSqlParam.put("image", image.getOriginalFilename());
            imageSqlParam.put("title", title);
            imageSqlParam.put("rules", rules);

            Map<String, String> categorySqlParam = new HashMap<>();
            categorySqlParam.put("category", category);
            categorySqlParam.put("title", title);

            sqlParam.put("title", title);
            sqlParam.put("context", context);
            sqlParam.put("category", category);
            sqlParam.put("headcount", headcount);
            sqlParam.put("age", age);
            sqlParam.put("difficulty", difficulty);
            sqlParam.put("time", time);
            sqlParam.put("price", price);


            dataService.setData(sqlParam, imageSqlParam, categorySqlParam);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }


}
