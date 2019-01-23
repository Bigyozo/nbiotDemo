package dut.zfl.nbiot.enums;

import lombok.Getter;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/19 17:09<br/>
 */
@Getter
public enum DeviceEnum implements CodeEnum{
    ACTIVE(1,"激活"),
    OFF(2,"关闭"),
    IDLE(3,"空闲");

    private Integer code;

    private String status;

    DeviceEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
