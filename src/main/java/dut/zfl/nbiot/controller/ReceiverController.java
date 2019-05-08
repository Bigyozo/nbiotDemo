package dut.zfl.nbiot.controller;

import dut.zfl.nbiot.pojo.MsgBean;
import dut.zfl.nbiot.pojo.MsgDev;
import dut.zfl.nbiot.service.LoadMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author zhangfl<br   />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/10 19:23<br/>
 */
@Controller
@RequestMapping("/show")
public class ReceiverController {

    @Autowired
    LoadMsgService loadMsgService;

    /*
     * 显示接受消息
     * */
    @GetMapping("/msg")
    public ModelAndView receive(Map<String, Object> map) {
        List<MsgBean> beanList = loadMsgService.loadAllMsg();
        map.put("beanList", beanList);
        return new ModelAndView("/show/msg", map);
    }

    /*
     * 显示iot设备及设备操作
     * */
    @GetMapping("/device")
    public ModelAndView device(Map<String, Object> map) {
        List<MsgDev> devList = loadMsgService.loadDevMsg();
        map.put("devList", devList);
        return new ModelAndView("/show/device",map);
    }


}


