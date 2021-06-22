package com.lyx.meituan.check;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.lyx.utils.FastJsonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2021/4/20
 * @description
 */
public class CheckQuantity {

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void main(String[] args) {
        final String file = "/Users/lyx/Documents/CaseDetail.json";
        final String fileContent = readFileContent(file);
        // System.out.println(fileContent);
        List<String> list = Lists.newArrayList();
        final JSONObject jsonObject = FastJsonUtils.parseObject(fileContent);
        final JSONArray jsonArray = jsonObject.getJSONObject("hits").getJSONArray("hits");
        for (Object o : jsonArray) {
            final String jsonStr = FastJsonUtils.toJSONStr(o);
            final JSONObject hitObj = FastJsonUtils.parseObject(jsonStr);
            final String id = hitObj.getJSONObject("_source").getString("id");
            list.add(id);
        }
        System.out.println(list.size());

        Set<String> set = new HashSet<>();
        for (String s : list) {
            if (!set.contains(s)) {
                set.add(s);
            } else {
                System.out.println(s);
            }
        }


    }
}
