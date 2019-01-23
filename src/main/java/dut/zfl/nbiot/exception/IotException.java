package dut.zfl.nbiot.exception;

import dut.zfl.nbiot.enums.ResultEnum;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 21:48<br/>
 */
public class IotException extends RuntimeException {
    private Integer code;

    public IotException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public IotException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
