package com.lyx.javaL.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author lvyunxiao
 * @classname MD5Demo
 * @description MD5Demo
 * @date 2020/3/16
 */
public class MD5Demo {

    public static String getMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
            md.update(plainText.getBytes());//此处传入要加密的byte类型值
            byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值

            /*
               下边的运算就是自己添加的一些二次小加密，记住这个千万不能弄错乱，
                否则在解密的时候，你会发现值不对的（举例：在注册的时候加密方式是一种，
                在我们登录的时候是不是还需要加密它的密码然后和数据库的进行比对，但是
             最后我们发现，明明密码对啊，就是打不到预期效果，这时候你就要想一下，你是否
             有改动前后的加密方式）
            */
            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) {
        //加密后的字符串
        // <!-- https://mvnrepository.com/artifact/commons-codec/commons-codec -->
        // <dependency>
        //     <groupId>commons-codec</groupId>
        //     <artifactId>commons-codec</artifactId>
        //     <version>1.14</version>
        // </dependency>
        String encodeStr = DigestUtils.md5Hex(text + key);
        // System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = md5("111", "123");
        String md5 = getMD5("111123");
        System.out.println(md5);
        System.out.println(s);
        boolean verify = verify("111", "123", "e49274516a27487f894ae956166eb7a4");
        System.out.println(verify);
    }
}
