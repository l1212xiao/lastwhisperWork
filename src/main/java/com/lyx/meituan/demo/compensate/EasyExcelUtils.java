package com.lyx.meituan.demo.compensate;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;


import java.io.*;
import java.util.*;

/**
 * @author lvyunxiao
 * @date 2021/12/23
 * @description
 */
@Slf4j
public class EasyExcelUtils {

    public static void readExcel(InputStream inStream, Class head, ReadListener listener) {
        EasyExcel.read(inStream, head, listener).sheet().doRead();
    }

    /**
     * 根据excel输入流，读取excel文件
     *
     * @param inputStream exece表格的输入流
     * @return 返回双重list的集合
     **/
    public static String writeWithoutHead(InputStream inputStream) {
        SyncReadListener listener = new SyncReadListener();
        ExcelReader excelReader = EasyExcelFactory.read(inputStream, null, listener).headRowNumber(0).build();
        excelReader.readAll();
        List<Object> list = listener.getList();
        log.info("读取结果:" + JSONObject.toJSONString(list));
        excelReader.finish();
        return JSONObject.toJSONString(list);
    }


    public static void main(String[] args) {
        String result = "";
        try {
            FileInputStream inp = new FileInputStream("/Users/lyx/Documents/compensate.xlsx");
            result = writeWithoutHead(inp);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

