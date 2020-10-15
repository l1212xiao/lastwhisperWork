package com.lyx.OwnLearning.Designpatterns.singleton;

/**
 * 【DCL】
 * 双重校验锁
 * lazy loading
 */
class Singleton_03_DCL {
    private static volatile Singleton_03_DCL instance;

    private Singleton_03_DCL() {
    }

    // 可以通过synchronized解决，但也带来效率下降
    public static /*synchronized*/ Singleton_03_DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton_03_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_03_DCL();
                }
            }
        }
        return instance;
    }
}

/**
 * 【饿汉式】
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
class Singleton_01 {
    private static final Singleton_01 instance = new Singleton_01();

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        return instance;
    }
}


/**
 * 【懒汉式】
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * <p>
 * 可以通过synchronized解决，但也带来效率下降
 */
class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    // 可以通过synchronized解决，但也带来效率下降
    public static /*synchronized*/ Singleton_02 getInstance() {
        if (instance == null) {
            synchronized (Singleton_02.class) {
                instance = new Singleton_02();
            }
        }
        return instance;
    }
}

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
class Singleton_04 {

    private Singleton_04() {
    }

    private static class Singleton_04Holder {
        private final static Singleton_04 INSTANCE = new Singleton_04();
    }

    public static Singleton_04 getInstance() {
        return Singleton_04Holder.INSTANCE;
    }

}

/**
 * 枚举
 * 不仅可以解决线程同步，还可以防止反序列化。
 */
enum Singleton_05 {
    INSTANCE;
    // public void m() {
    // }
}