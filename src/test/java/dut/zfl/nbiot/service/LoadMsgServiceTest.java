package dut.zfl.nbiot.service;

import dut.zfl.nbiot.pojo.MsgBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 22:40<br/>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadMsgServiceTest {
    @Autowired
    LoadMsgService loadMsgService;

    @Test
    public void loadAllMsg() {
        List<MsgBean> beanList=loadMsgService.LoadAllMsg();
        System.out.println(beanList);
    }
}