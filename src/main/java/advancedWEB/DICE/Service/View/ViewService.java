package advancedWEB.DICE.Service.View;

import advancedWEB.DICE.Domain.View.AboutView;
import advancedWEB.DICE.Service.Search.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
    @Autowired
    private ViewMapper viewMapper;

    public AboutView AboutViewByID(String ID){
        AboutView TempAbout = viewMapper.AboutViewByID(ID);
        if(TempAbout == null) {
            return TempAbout;
        }
        String TempFilePath = TempAbout.getFiles();
        TempFilePath = "http://15.164.232.90/Images/" + TempFilePath;
        TempAbout.setFiles(TempFilePath);
        return TempAbout;
    }
}
