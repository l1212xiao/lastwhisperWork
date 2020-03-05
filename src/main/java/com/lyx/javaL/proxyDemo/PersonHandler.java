package com.lyx.javaL.proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lvyunxiao
 * @classname PersonHandler
 * @description PersonHandler
 * @date 2020/3/5
 */
public class PersonHandler<T> implements InvocationHandler {

    /**
     * 代理的目标对象
     */
    private T mTarget;


    public PersonHandler(T target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 调用开始前的操作
        ProxyUtil.start();
        // 调用方法,通过反射的形式来调用 mTarget 的 method
        Object result = method.invoke(mTarget, objects);
        // 打印改名前的名字
        ProxyUtil.log(objects[0].toString());
        // 调用结束后的操作
        ProxyUtil.finish();
        return result;
    }
}
