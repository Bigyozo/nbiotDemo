package dut.zfl.nbiot.controller;

import dut.zfl.nbiot.pojo.MsgBean;
import dut.zfl.nbiot.pojo.MsgDev;
import dut.zfl.nbiot.service.LoadMsgService;
import dut.zfl.nbiot.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/nbiot")
public class ReceiverController {
    @Autowired
    ReceiverService receiverService;
    @Autowired
    LoadMsgService loadMsgService;

    /*
     * 显示接受消息
     * */
    @GetMapping("/show")
    public ModelAndView receive(@RequestParam(value = "open", defaultValue = "true") Boolean open
            , Map<String, Object> map) {
        receiverService.change(open);
        List<MsgBean> beanList = loadMsgService.loadAllMsg();
        map.put("beanList", beanList);
        map.put("isOpen", open);
        return new ModelAndView("/show/demo", map);
    }

    /*
     * 显示在线设备及设备操作
     * */
    @GetMapping("/device")
    public ModelAndView device(@RequestParam(value = "open", defaultValue = "true") Boolean open
            , Map<String, Object> map) {
        receiverService.change(open);
        List<MsgDev> devList = loadMsgService.loadDevMsg();
        map.put("devList", devList);
        map.put("isOpen", open);
        return new ModelAndView("/show/device",map);
    }


}


