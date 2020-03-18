package com.lyx.javaL.uuid;

import java.util.UUID;

/**
 * @author lvyunxiao
 * @classname UUIDDemo
 * @description UUIDDemo
 * @date 2020/3/16
 * <p>
 * UUID是什么？
 * UUID 是 通用唯一识别码（Universally Unique Identifier）的缩写，是一种软件建构的标准，亦为开放软件基金会组织在分布式计算环境领域的一部分。
 * 其目的，是让分布式系统中的所有元素，都能有唯一的辨识信息，而不需要通过中央控制端来做辨识信息的指定。
 * 如此一来，每个人都可以创建不与其它人冲突的UUID。在这样的情况下，就不需考虑数据库创建时的名称重复问题。-----来自百度百科
 * <p>
 * UUID组成：
 * UUID是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的。
 * <p>
 * UUID由以下几部分的组合：
 * （1）当前日期和时间，UUID的第一个部分与时间有关，如果你在生成一个UUID之后，过几秒又生成一个UUID，则第一个部分不同，其余相同。
 * （2）时钟序列。
 * （3）全局唯一的IEEE机器识别号，如果有网卡，从网卡MAC地址获得，没有网卡以其他方式获得。
 * <p>
 * UUID在一般情况下很难生成一致的编码，不是说绝对的，但是就现在一般的使用情况下没有重复的出现，利用这个特点我们可以作为数据库的主键区分各个实例。
 * UUID的格式如下，因为java中有UUID这个工具类，专门来生成UUID，在java.util包中，所以很简单，直接调用方法UUID.randomUUID()即可
 */
public class UUIDDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);   // demo: 7d67b9c2-a689-41e6-92f6-9ffb9a1f854c
            System.out.println(uuid.length()); //36
        }
    }
}
