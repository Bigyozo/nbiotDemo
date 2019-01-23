package dut.zfl.nbiot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangfl<br   />
 * @program:nbiotDemo
 * @Description: <br/>
 * @create: 2019/1/17 23:03<br/>
 */
public class DateUtil {
    public static String getDateStr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static Date toDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        return dateFormat.parse(dateStr);
    }
}
