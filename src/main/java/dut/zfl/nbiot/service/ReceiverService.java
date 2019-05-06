package dut.zfl.nbiot.service;

import dut.zfl.nbiot.component.OIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: 接受类的控制类<br/>
 * @create: 2019/1/10 19:25<br/>
 */
@Service
public class ReceiverService {
    @Autowired
    OIOServer oioServer;

    @PostConstruct
    public void init(){
        Thread thread=new Thread(oioServer);
        thread.start();
        System.out.println("OIO开始接受信息");
    }

    public void restart(){
        if(!oioServer.getFlag()) {
            oioServer.setFlag(true);
            Thread thread = new Thread(oioServer);
            thread.start();
            System.out.println("重新开始接受信息");
        }
    }

    public void close(){
        oioServer.setFlag(false);
        System.out.println("中止接受信息");
    }

    public boolean isOpen(){
        return oioServer.getFlag();
    }

    public void change(boolean open){
        boolean isOpen = this.isOpen();
        if (open == true && !isOpen)
            this.restart();
        else if (open == false && isOpen)
            this.close();
    }
}
