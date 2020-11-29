package advancedWEB.DICE.Service.Data;

import advancedWEB.DICE.Domain.Data.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataMapper dataMapper;

    public String IDCategory(String ID) {
        return dataMapper.IDCategory(ID);
    }
    //검색
    public List<Category> RankingAllWithLimit(int Page, int NumPage) {

        List<Category> result_List = dataMapper.CategoryWithLimit(Page * NumPage, NumPage);

        for(int i = 0; i < result_List.size(); i++) {
            Category TempResult = result_List.get(i);
            String TempFilePath = TempResult.getFiles();
            TempFilePath = "http://15.164.232.90/Images/" + TempFilePath;
            TempResult.setFiles(TempFilePath);
            result_List.set(i,TempResult);
        }

        return result_List;
    }

}
