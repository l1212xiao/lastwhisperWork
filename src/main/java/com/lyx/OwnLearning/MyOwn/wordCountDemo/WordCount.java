package com.lyx.OwnLearning.MyOwn.wordCountDemo;

/**
 * Created by lyx on 2018/5/15.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount {
    public static void main(String args[]) throws IOException {
        Hashtable<String, Integer> wordCount = new Hashtable<String, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:/input")), "utf-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/output")), "utf-8"));
        String s = null;
        int c = 0;
        while ((s = reader.readLine()) != null) {
            String arry[] = s.split(" ");
            for (int i = 0; i < arry.length; i++) {
                if (!wordCount.containsKey(arry[i])) {
                    wordCount.put(arry[i], 1);
                } else {
                    wordCount.put(arry[i], wordCount.get(arry[i]).intValue() + 1);
                }
            }
        }
        for (Entry<String, Integer> entry : wordCount.entrySet()) {
            //writer.write(entry.getKey() + " " + entry.getValue() + "\r\n");
            writer.append(entry.getKey() + " " + entry.getValue() + "\r\n");
            writer.flush();
        }

        //将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序排序
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                //return o1.getValue().compareTo(o2.getValue());
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + "  :  " + mapping.getValue());
        }

    }

}