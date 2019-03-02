/**
 * Created by yuntian on 2019/2/26.
 */
import dao.DomeMapper;
import entity.Dome;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-mybatis.xml")
public class DomeTest {
    @Autowired
    private DomeMapper domeMapper;
    @Test
    public void InsertDomeTest(){
        Dome dome=new Dome();
        dome.setUserName("Test01");
        dome.setPassword("12345678");
        System.out.println(domeMapper.insertdome(dome));
    }
    @Test
    public void SelectAllTest(){
        List list=domeMapper.selectAll();
        for(Object dome:list){
            System.out.println(dome.toString());
        }
    }
}
