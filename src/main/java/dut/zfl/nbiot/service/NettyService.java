package dut.zfl.nbiot.service;


import dut.zfl.nbiot.component.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 20:57
 * @Description:
 */
@Service
public class NettyService {
    @Autowired
    NettyServer nettyServer;

    @PostConstruct
    public void init(){
        System.out.println("开始接受信息");
        try {
            nettyServer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
