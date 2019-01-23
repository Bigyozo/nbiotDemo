package dut.zfl.nbiot.service;

import dut.zfl.nbiot.pojo.MsgBean;
import dut.zfl.nbiot.util.MsgBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhangfl<br   />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 21:58<br/>
 */
@Service
public class LoadMsgService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public List<MsgBean> LoadAllMsg() {
        Set<String> keySet = redisTemplate.keys("ID" + "*");
        List<MsgBean> msgBeanList = new ArrayList<>();
        for (String key : keySet) {
            long size = redisTemplate.opsForList().size(key);
            while (size-- > 0) {
                String msg = redisTemplate.opsForList().rightPop(key);
                redisTemplate.opsForList().leftPush(key,msg);
                msgBeanList.add(MsgBeanUtil.toMsgBean(msg));
            }
        }
        return msgBeanList;
    }
}
