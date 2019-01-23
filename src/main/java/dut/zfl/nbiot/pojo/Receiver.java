package dut.zfl.nbiot.pojo;

import dut.zfl.nbiot.enums.ResultEnum;
import dut.zfl.nbiot.exception.IotException;
import dut.zfl.nbiot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/6 17:23<br/>
 */
@Component
public class Receiver implements Runnable{
    @Autowired
    private StringRedisTemplate redisTemplate;

    private DatagramSocket socket;
    private int port;
    private volatile boolean flag=true;

    public Receiver() {
        this(9898);
    }

    public Receiver(int port) {
        this.port=port;
        try {
            this.socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(flag){
            byte[] data=new byte[1024];
            DatagramPacket packet=new DatagramPacket(data,data.length);
            try {
                socket.receive(packet);
                String message=new String(packet.getData(),0,packet.getLength());
                String[] msg=message.split("\\s+",2);
                String date=DateUtil.getDateStr();
                message+=" "+date;
                redisTemplate.opsForList().rightPush(msg[0],message);
                redisTemplate.expire(msg[0],7200, TimeUnit.SECONDS);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IotException(ResultEnum.RECEIVE_ERROR);
            }
        }
    }

    public void setFlag(boolean value){
        this.flag=value;
    }

}
