package dut.zfl.nbiot.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/7/007 21:41
 * @Description:
 */
@Configuration
@EnableAsync
public class TaskThreadPool {
    @Autowired
    private TaskThreadPoolConfig config;

    @Bean
    public Executor createPool(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(config.getCorePoolSize());
        executor.setMaxPoolSize(config.getMaxPoolSize());
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        executor.setQueueCapacity(config.getQueueCapacity());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }
}
