package com.lyx.geek.AlgoMei.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lvyunxiao
 * @date 2021/9/6
 * @description
 */
public class MapDemo {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();

        HashMap<String, String> hashMap = new HashMap();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        Map<String, String> synchronizedMap = Collections.synchronizedMap(hashMap);

    }

}
