package com.lyx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * @author lvyunxiao
 * @classname FastJsonUtils
 * @description FastJsonUtils
 * @date 2020/5/18
 */
public class FastJsonUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }

    private static final SerializerFeature[] features = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.PrettyFormat
    };

    /**
     * object 转为 json
     *
     * @param object 对象
     * @return json string
     */
    public static String toJSONStr(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * object 转为 json 日期格式转为默认格式
     *
     * @param object 对象
     * @return json string
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONStringWithDateFormat(object, DATE_FORMAT, features);
    }

    /**
     * object转为string,不带feature
     *
     * @param object 对象
     * @return json string
     */
    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, config);
    }

    /**
     * 字符串转为Object
     *
     * @param text 字符串
     * @return 对象
     */
    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    /**
     * json字符串转java对象
     */
    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> T toBean(JSONObject jsonObject, Class<T> clazz) {
        return JSONObject.parseObject(jsonObject.toJSONString(), clazz);
    }

    /**
     * 转换为数组
     */
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    /**
     * 转换为数组
     */
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * 转换为List
     */
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将json转换成Map
     */
    public static <T> T jsonToMap(JSON json) {
        return (T) JSONObject.toJavaObject(json, Map.class);
    }

    /**
     * 将json string转换成Map
     */
    public static <T> T jsonStrToMap(String jsonStr) {
        return (T) JSONObject.parseObject(jsonStr, Map.class);
    }

    /**
     * 将jsonObj转换成Map
     */
    public static <T> T jsonObjToMap(JSONObject jsonObject) {
        return jsonStrToMap(jsonObject.toJSONString());
    }

    /**
     * json字符串转化为map
     *
     * @param s string
     * @return Map
     */
    public static Map stringToMap(String s) {
        return JSONObject.parseObject(s);
    }

    /**
     * 将map转化为string
     *
     * @param m map
     * @return string
     */
    public static String collectToString(Map m) {
        return JSONObject.toJSONString(m);
    }

    /**
     * 解析对象为JSONObject
     *
     * @param str string
     * @return JSONObject
     */
    public static JSONObject parseObject(String str) {
        return JSON.parseObject(str);
    }

    /**
     * 解析对象为JSONArray
     *
     * @param str string
     * @return JSONArray
     */
    public static JSONArray parseArray(String str) {
        return JSON.parseArray(str);
    }
}
