package com.lyx.OwnLearning.bytes;

import java.io.UnsupportedEncodingException;

/**
 * @Classname BytesDemo
 * @Description BytesDemo
 * @Date 2019/9/24
 * @auther lvyunxiao
 */
public class BytesDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //1、将字符转换成byte数组
        String str = "猫猫";
        byte[] sb = str.getBytes("UTF-8");
        //System.out.println(sb);
        //for (final byte b : sb) {
        //    System.out.print(b + " ");
        //}

        //2、将byte数组转换成字符
        //byte[] b = {(byte) 0xB8, (byte) 0xDF, (byte) 0xCB, (byte) 0xD9};
        //System.out.println("");
        byte[] bytes = {(byte) -25, (byte) -116, (byte) -85, (byte) -25, (byte) -116, (byte) -85};


//        byte[] b1 = {(byte) 0xE6, (byte) 0xAC, (byte) 0xA7, (byte) 0xE6,
//                (byte) 0x9B, (byte) 0xBC, (byte) 0xE7, (byte) 0x89, (byte) 0x8C,};
//        String s1 = new String(b1, "UTF-8");
//        System.out.println(s1);
//        String strb = new String(bytes, "UTF-8");

//        int e6 = Integer.parseInt("E6", 16);
//        byte e61 = Byte.parseByte("E", 16);
//        byte b = (byte) 0xE6;


        //String content = "\\xE6\\xAC\\xA7\\xE6\\x9B\\xBC\\xE7\\x89\\x8C";
        String content = "\\xCE\\xB4\\xD6\\xAA\\xEF\\xBF\\xBD\\xEF\\xBF\\xBD\\xEF\\xBF\\xBD\\xEF\\xBF\\xBD";
        String[] split = content.split("\\\\x");
        byte[] bytes1 = new byte[split.length - 1];
        for (int i = 1; i < split.length; i++) {
            int i1 = Integer.decode("0x" + split[i]);
            bytes1[i - 1] = (byte) (i1);
        }
        String s = new String(bytes1, "UTF-8");
        System.out.println(s);

//        String replace = "0x" + content.replace("\\x", "");
//        byte[] bytes1 = hexToByte(replace);
//
//        String str1 = new String(bytes1, "UTF-8");
//        System.out.println(str1);

    }

    /**
     * hex转byte数组
     *
     * @param hex hex string
     * @return byte[]
     */
    public static byte[] hexToByte(String hex) {
        int m = 0, n = 0;
        int byteLen = hex.length() / 2; // 每两个字符描述一个字节
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
            ret[i] = Byte.valueOf((byte) intVal);
        }
        return ret;
    }

}
