package dut.zfl.nbiot.pojo;

import dut.zfl.nbiot.enums.DeviceEnum;
import dut.zfl.nbiot.util.EnumUtil;
import lombok.Data;

/**
 * @author zhangfl<br   />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/26 16:47<br/>
 */
@Data
public class MsgDev {
    String id;
    Integer status;

    public MsgDev(String id, Integer status) {
        this.id = id;
        this.status = status;
    }

    public DeviceEnum getDeviceEnum() {
        return EnumUtil.getByCode(this.status, DeviceEnum.class);
    }
}
