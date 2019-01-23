package dut.zfl.nbiot.util;

import dut.zfl.nbiot.enums.CodeEnum;

/**
 * @author zhangfl<br />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/19 17:15<br/>
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
