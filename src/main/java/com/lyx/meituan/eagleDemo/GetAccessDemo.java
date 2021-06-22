package com.lyx.meituan.eagleDemo;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author lvyunxiao
 * @date 2021/3/23
 * @description
 */
public class GetAccessDemo {

    public static void main(String[] args) {
        String accesskey = "2A2E13921C5E52CD33EC5C3B7F9C6933";
        // final String token = generateToken(accesskey);
        final String token = md5(accesskey);
        System.out.println(token);

    }

    /**
     * Hash 文本字符串
     * @param original 原文
     * @return Hash 结果
     */
    public static String md5(String original) {
        return DigestUtils.md5Hex(original);
    }

    public static String generateToken(String accesskey) {
        long ts = System.currentTimeMillis();
        return ts + "," + md5(ts + "::" + accesskey);
    }

}
