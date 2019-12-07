package com.baijiaxiu.services.cloud.common.utils;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-08-30 18:55
 */
@Slf4j
public class ExcelUtils {

    /**
     * 下载文件
     *
     * @param response  响应
     * @param clazz     模板类
     * @param data      数据
     * @param sheetName sheet名称
     */
    public static void download(HttpServletResponse response, Class<?> clazz, List<?> data, String sheetName) {
        try {
            String fileName = DateUtils.format(new Date(), DateUtils.DATE_PATTERN);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));
            EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
