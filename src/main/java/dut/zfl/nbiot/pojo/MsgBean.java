package dut.zfl.nbiot.pojo;

import dut.zfl.nbiot.enums.DeviceEnum;
import dut.zfl.nbiot.enums.ResultEnum;
import dut.zfl.nbiot.exception.IotException;
import dut.zfl.nbiot.util.DateUtil;
import dut.zfl.nbiot.util.EnumUtil;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;

/**
 * @author zhangfl<br   />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 21:27<br/>
 */
@Data
public class MsgBean {
    String id;
    String brightness;
    String temperature;
    String current;
    Integer status;
    Date time;

    public MsgBean(String[] args) {
        if (args.length != 6)
            throw new IotException(ResultEnum.MSGBEAN_INIT_ERROR);
        this.id = args[0];
        this.brightness = args[1];
        this.temperature = args[2];
        this.current = args[3];
        this.status = Integer.parseInt(args[4]);
        try {
            this.time = DateUtil.toDate(args[5]);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IotException(ResultEnum.MSGBEAN_INIT_ERROR);
        }
    }

    public DeviceEnum getDeviceEnum(){
        return EnumUtil.getByCode(this.status,DeviceEnum.class);
    }

}
