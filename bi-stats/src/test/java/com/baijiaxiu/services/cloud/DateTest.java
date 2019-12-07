package com.baijiaxiu.services.cloud;

import com.baijiaxiu.services.cloud.common.utils.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-09-04 17:01
 */
public class DateTest {
    @Test
    public void testDateA() {
        String startTime = "20190901";
        String endTime = "20190903";
        String format = "yyyyMMdd";
        Long yyyyMMdd = DateUtils.dayDiff(startTime, endTime, format);
        Date startDate = DateUtils.stringToDate(startTime, format);
        Date endDate = DateUtils.stringToDate(endTime, format);
        Long l = yyyyMMdd - 1;

        Date date = DateUtils.addDateDays(startDate, l.intValue());
        Date date2 = DateUtils.addDateDays(endDate, l.intValue());


        String format1 = DateUtils.format(date, format);
        String format2 = DateUtils.format(date2, format);
        System.out.println(format1 + ":" + format2);

    }
}
