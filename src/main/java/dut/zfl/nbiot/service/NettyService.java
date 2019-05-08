package dut.zfl.nbiot.service;


import dut.zfl.nbiot.component.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 20:57
 * @Description:
 */
@Service
public class NettyService implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    NettyServer nettyServer;

    @Value("${udpReceivePort}")
    int udpReceivePort;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            nettyServer.start(udpReceivePort);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
