package dut.zfl.nbiot.component;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 20:58
 * @Description: netty NIO udp server
 */
@Component
public class NettyServer {
    private Bootstrap bootstrap = new Bootstrap();
    private EventLoopGroup group = new NioEventLoopGroup();
    @Autowired
    private ReceiverHandler receiverHandler;

    @Async
    public void start(int port) throws InterruptedException {
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(receiverHandler);
        bootstrap.bind(port).sync().channel().closeFuture().await();
    }


    @PreDestroy
    public void close(){
        group.shutdownGracefully();
    }

}
