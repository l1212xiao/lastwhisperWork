package com.lyx.javaL.proxyDemo;

import java.lang.reflect.Proxy;

/**
 * @author lvyunxiao
 * @classname MainActivity
 * @description MainActivity
 * @date 2020/3/5
 */
public class MainActivity {

    protected void onCreate() {

        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的 InvocationHandler
        PersonHandler stuHandler = new PersonHandler<>(zhangsan);

        //创建一个代理对象 stuProxy 来代理 zhangsan，代理对象的每个执行方法都会替换执行 Invocation 中的 invoke 方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行 setName 的方法，代理实例内部又会调用 stuHandler 的 invoke方法，在通过反射调用了调用了被代理对象的方法
        stuProxy.setName("王五");
    }

    public static void main(String[] args) {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onCreate();
    }
}
