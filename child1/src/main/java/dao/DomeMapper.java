package dao;

/**
 * Created by yuntian on 2019/2/26.
 */
import entity.Dome;

import java.util.List;

public interface DomeMapper {
    List<Dome> selectAll();
    int insertdome(Dome dome);
}
