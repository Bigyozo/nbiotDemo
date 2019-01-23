package dut.zfl.nbiot.controller;

import dut.zfl.nbiot.pojo.MsgBean;
import dut.zfl.nbiot.service.LoadMsgService;
import dut.zfl.nbiot.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/10 19:23<br/>
 */
@Controller
@RequestMapping("/nbiot")
public class ReceiverController {
    @Autowired
    ReceiverService receiverService;
    @Autowired
    LoadMsgService loadMsgService;

    @GetMapping("/show")
    public ModelAndView receive(Map<String, Object> map){
        List<MsgBean> beanList=loadMsgService.LoadAllMsg();
        map.put("beanList",beanList);
        return new ModelAndView("/show/demo",map);
    }

}


