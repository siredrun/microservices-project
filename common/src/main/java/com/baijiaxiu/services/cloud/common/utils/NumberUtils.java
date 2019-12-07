package com.baijiaxiu.services.cloud.common.utils;

import java.math.BigDecimal;

/**
 * @description: 数字工具类
 * @author: liuyufeng
 * @date: 2019-09-02 13:59
 */
public class NumberUtils {
    /**
     * 小数转百分数
     *
     * @param d
     * @return
     */
    public static String formatDouble(Double d) {
        BigDecimal bg = BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return bg.toString() + "%";
    }


    /**
     * 格式化数
     *
     * @param d
     * @param decimals 小数位
     * @return
     */
    public static String formatDouble(Double d, Integer decimals) {
        BigDecimal bg = BigDecimal.valueOf(d).setScale(decimals, BigDecimal.ROUND_HALF_UP);
        return bg.toString();
    }
}
