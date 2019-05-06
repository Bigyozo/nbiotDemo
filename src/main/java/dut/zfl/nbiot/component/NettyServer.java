package dut.zfl.nbiot.component;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/6/006 20:58
 * @Description:
 */
@Component
public class NettyServer {
    private Bootstrap bootstrap = new Bootstrap();
    private EventLoopGroup group = new NioEventLoopGroup();
    @Autowired
    private ReceiverHandler receiverHandler;

    public void start() throws InterruptedException {
        System.out.println("server 1");
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .handler(receiverHandler);
        bootstrap.bind(9899).sync().channel().closeFuture().await();
        System.out.println("server 2");
    }

    @PreDestroy
    public void close(){
        group.shutdownGracefully();
    }
}
