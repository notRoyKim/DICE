package advancedWEB.DICE.Service.View;

import advancedWEB.DICE.Domain.View.AboutView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ViewMapper {
    @Select("SELECT * FROM AboutView WHERE ID = ${ID}")
    AboutView AboutViewByID(String ID);
}
