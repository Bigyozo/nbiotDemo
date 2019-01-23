package dut.zfl.nbiot.util;

import dut.zfl.nbiot.pojo.MsgBean;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 22:55<br/>
 */
public class MsgBeanUtil {
    public static MsgBean toMsgBean(String str){
        String[] strings=str.split("\\s");
        MsgBean bean=new MsgBean(strings);
        return bean;
    }
}
