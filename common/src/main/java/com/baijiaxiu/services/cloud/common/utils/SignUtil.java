package com.baijiaxiu.services.cloud.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 验签工具类
 * @author: liuyufeng
 * @date: 2019-11-06 14:46
 */
@Slf4j
public class SignUtil {


    /**
     * 除去数组中的空值和签名参数
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static TreeMap<String, Object> paraFilter(Map<String, Object> sArray) {
        TreeMap<String, Object> result = new TreeMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            Object value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * 获取验签
     *
     * @return
     */
    public static String getSign(Object data, String secretId, String secretKey) {
        // 过滤验签
        TreeMap parseMap = JSON.parseObject(JSON.toJSONString(data), TreeMap.class);
        String dataJson = JSON.toJSONString(paraFilter(parseMap));
        return DigestUtils.md5Hex(secretId + dataJson + secretKey);
    }

}
