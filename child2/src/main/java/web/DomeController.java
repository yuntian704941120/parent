package web;/** * Created by yuntian on 2019/2/26. */import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.servlet.ModelAndView;import service.DomeService;import javax.servlet.http.HttpServletRequest;import java.util.List;@Controllerpublic class DomeController {    @Autowired    private DomeService domeService;    @RequestMapping("/index")    public ModelAndView index(HttpServletRequest request){        System.out.println("展示数据："+getIP(request));        List list=domeService.index();        ModelAndView mav =new ModelAndView();        mav.setViewName("index");        mav.addObject("userList",list);        return mav;    }    @RequestMapping("/main")    public ModelAndView main(){        System.out.println("进入首页"); //        List list=domeService.index();        ModelAndView mav =new ModelAndView();        mav.setViewName("hello");//        mav.addObject("userList",list);        return mav;    }    public String getIP(HttpServletRequest request){        String ip="127.0.0.1";        ip=request.getHeader("x-forwarded-for");        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){            ip=request.getHeader("Proxy-Client-IP");        }        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){            ip=request.getHeader("WL-Proxy-Client-IP");        }        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){            ip=request.getHeader("X-Real-IP");        }        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){            ip=request.getRemoteAddr();        }        return ip;    }}