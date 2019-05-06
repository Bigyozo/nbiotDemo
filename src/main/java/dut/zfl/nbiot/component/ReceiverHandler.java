package dut.zfl.nbiot.component;

import dut.zfl.nbiot.util.DateUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 21:09
 * @Description:
 */
@Component
public class ReceiverHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket packet) throws Exception {
        byte[] arr=packet.getData();
        String message=new String(arr,0,packet.getLength());
        System.out.println(message);
        String[] msg=message.split("\\s+");
        String date= DateUtil.getDateStr();
        message+=" "+date;
        redisTemplate.opsForList().rightPush(msg[0],message);
        redisTemplate.expire(msg[0],48, TimeUnit.HOURS);
        redisTemplate.opsForValue().set("State_"+msg[0],msg[4]);
    }
}
