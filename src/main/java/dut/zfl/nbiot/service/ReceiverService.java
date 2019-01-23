package dut.zfl.nbiot.service;

import dut.zfl.nbiot.pojo.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/10 19:25<br/>
 */
@Service
public class ReceiverService {
    @Autowired
    Receiver receiver;

    @PostConstruct
    public void init(){
        Thread thread=new Thread(receiver);
        thread.start();
        System.out.println("开始接受信息");
    }

    public void isReceiverOpen(Boolean isOpen){
        receiver.setFlag(isOpen);
    }

}
