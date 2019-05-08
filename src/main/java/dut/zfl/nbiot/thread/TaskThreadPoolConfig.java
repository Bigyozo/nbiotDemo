package dut.zfl.nbiot.thread;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: zhangfanglong
 * @Date: 2019/5/7/007 21:50
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.task.pool")
public class TaskThreadPoolConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

}
