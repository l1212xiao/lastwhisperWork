package com.lyx.javaL;

import java.lang.reflect.Method;

/**
 * @author lvyunxiao
 * @classname MethodInvokeDemo
 * @description MethodInvokeDemo
 * @date 2019/11/4
 * <p>
 * ref:https://blog.csdn.net/wenyuan65/article/details/81145900
 */
public class MethodInvokeDemo {
    public static void main(String[] args) throws Exception {
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cat.class.getDeclaredMethod("print");

        Animal animal = new Animal();
        Cat cat = new Cat();
        animalMethod.invoke(cat);
        animalMethod.invoke(animal);

        catMethod.invoke(cat);
        catMethod.invoke(animal);
    }

}

class Animal {

    public void print() {
        System.out.println("Animal.print()");
    }

}

class Cat extends Animal {

    @Override
    public void print() {
        System.out.println("Cat.print()");
    }

}