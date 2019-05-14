package dut.zfl.nbiot.component;

import dut.zfl.nbiot.util.DateUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 21:09
 * @Description:消息处理handler
 */
@Component
public class ReceiverHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket packet){
        String message=packet.content().toString(CharsetUtil.UTF_8);
        String[] msg=message.split("\\s+");
        String date= DateUtil.getDateStr();
        message+=" "+date;
        redisTemplate.opsForList().rightPush(msg[0],message);
        redisTemplate.expire(msg[0],72, TimeUnit.HOURS);
        redisTemplate.opsForValue().set("State_"+msg[0],msg[4]);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
