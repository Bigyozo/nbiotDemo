package dut.zfl.nbiot.enums;

import lombok.Getter;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 21:51<br/>
 */
@Getter
public enum ResultEnum {
    RECEIVE_ERROR(1,"接收消息失败"),
    MSGBEAN_INIT_ERROR(2,"消息对象创建失败，接受消息格式不正确");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
