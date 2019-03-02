package service;

import dao.DomeMapper;
import entity.Dome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DomeService {
    @Autowired
    private DomeMapper domeMapper;
    public List index(){
        Dome dome=new Dome();
        dome.setUserName(getRandomString(3));
        dome.setPassword(getRandomString(6));
//        domeMapper.insertdome(dome);
        return domeMapper.selectAll();
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



}
