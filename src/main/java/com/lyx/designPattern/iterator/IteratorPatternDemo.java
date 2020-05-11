package com.lyx.designPattern.iterator;

/**
 * @author lvyunxiao
 * @classname IteratorPatternDemo
 * @description IteratorPatternDemo
 * @date 2020/5/7
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
