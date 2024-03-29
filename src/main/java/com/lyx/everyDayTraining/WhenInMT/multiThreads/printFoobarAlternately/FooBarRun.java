package com.lyx.everyDayTraining.WhenInMT.multiThreads.printFoobarAlternately;

/*
1115. 交替打印FooBar

我们提供一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}

两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
请设计修改程序，以确保 "foobar" 被输出 n 次。

示例 1:

输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

示例 2:

输入: n = 2
输出: "foobarfoobar"
解释: "foobar" 将被输出两次。
 */

// class PrintFoo implements Runnable {
//     @Override
//     public void run() {
//         System.out.print("foo");
//     }
// }
//
// class PrintBar implements Runnable {
//     @Override
//     public void run() {
//         System.out.print("bar");
//     }
// }


import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.awt.image.ImageWatched.Link;

/**
 * @author lvyunxiao
 * @date 2021/9/3
 * @description ref:https://leetcode-cn.com/problems/print-foobar-alternately/solution/chang-you-duo-xian-cheng-zhi-1115-by-a-f-mf5u/
 */
public class FooBarRun {

    public static void main(String[] args) throws InterruptedException {

        // TransferQueue<Character> transferQueue = new LinkedTransferQueue<>();
        //
        // transferQueue.take();
        // transferQueue.transfer();


        FooBar6 fooBar = new FooBar6(10);//打印10次foo bar
        Runnable printFoo = () -> System.out.println("foo");
        Runnable printBar = () -> System.out.println("bar");
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
    }
}

/*
方法1:Semaphore

    Semaphore是一个计数信号量。
    从概念上将，Semaphore包含一组许可证。
    如果有需要的话，每个acquire()方法都会阻塞，直到获取一个可用的许可证。
    每个release()方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证。
    然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护
    总结：如果线程要访问一个资源就必须先获得信号量。如果信号量内部计数器大于0，信号量减1，然后允许共享这个资源；
        否则，如果信号量的计数器等于0，信号量将会把线程置入休眠直至计数器大于0.当信号量使用完时，必须释放
 */
class FooBar1 {
    private int n;

    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSema.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSema.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSema.release();
        }
    }
}

/*
方法2:CyclicBarrier
CyclicBarrier 与 CountDownLatch 区别

    CountDownLatch 是一次性的，CyclicBarrier 是可循环利用的
    CountDownLatch 参与的线程的职责是不一样的，有的在倒计时，有的在等待倒计时结束。CyclicBarrier 参与的线程职责是一样的
 */
class FooBar2 {

    private int n;

    private CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fooExec = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                // false的时候，bar线程在执行，foo线程在此处空转
            }
            printFoo.run(); // 打印foo
            fooExec = false;
            try {
                cb.await(); // 线程foo到达同步点
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooExec = true;
        }
    }
}

/*
方法3:Thread.yield()

Thread.yield():使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
cpu会从众多的可执行态里选择，也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，
并不是说一定会执行其他线程而该线程在下一次中不会执行到了。

 */
class FooBar3 {
    private int n;

    volatile boolean fooExec = true;//foo可以执行

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (fooExec) {
                printFoo.run();
                fooExec = false;
                i++;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (!fooExec) {
                printBar.run();
                fooExec = true;
                i++;
            } else {
                Thread.yield();
            }
        }
    }

}

/*
方法4:ReentrantLock
背景知识
实现原理

ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。

CAS：Compare and Swap，比较并交换。CAS有3个操作数：内存值V、预期值A、要修改的新值B。
当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。该操作是一个原子操作，
被广泛的应用在Java的底层实现中。在Java中，CAS主要是由sun.misc.Unsafe这个类通过JNI调用CPU底层指令实现

ReentrantLock主要利用CAS+AQS队列来实现。它支持公平锁和非公平锁，两者的实现类似。

ReentrantLock和synchronized比较
    1.ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区。但是实现上两者不同:
        synchronized加锁解锁的过程是隐式的,用户不用手动操作,优点是操作简单，但显得不够灵活。
        一般并发场景使用synchronized的就够了；ReentrantLock需要手动加锁和解锁,且解锁的操作尽量要放在finally代码块中,保证线程正确释放锁。
        ReentrantLock操作较为复杂，但是因为可以手动控制加锁和解锁过程,在复杂的并发场景中能派上用场。
    2.ReentrantLock和synchronized都是可重入的。synchronized因为可重入因此可以放在被递归执行的方法上,且不用担心线程最后能否正确释放锁；
        而ReentrantLock在重入时要却确保重复获取锁的次数必须和重复释放锁的次数一样，否则可能导致其他线程无法获得该锁
    n=5的时候，已经显示TLE了

 */
class FooBar4 {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    volatile boolean fooExec = true;

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (fooExec) {
                    printFoo.run();
                    fooExec = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExec) {
                    printBar.run();
                    fooExec = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

/*
方法5:BlockingQueue
背景知识

    SynchronousQueue： 一个不存储元素的阻塞队列，每一个put操作必须等待take操作，否则不能添加元素。支持公平锁和非公平锁。
        SynchronousQueue的一个使用场景是在线程池里。Executors.newCachedThreadPool()就使用了SynchronousQueue，
        这个线程池根据需要（新任务到来时）创建新的线程，如果有空闲线程则会重复使用，线程空闲了60秒后会被回收。
    LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。队列头部和尾部都可以添加和移除元素，多线程并发时，可以将锁的竞争最多降到一半

    add(obj):把obj加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
    take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到BlockingQueue有新的数据被加入;
 */
class FooBar5 {
    private int n;
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>() {{
        add(0);
    }};
    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();

    public FooBar5(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooQueue.take();
            printFoo.run();
            barQueue.add(0);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.add(0);
        }
    }
}

/*
方法6:synchronized
背景知识

1、wait()、notify/notifyAll() 方法是Object的本地final方法，无法被重写。
2、wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
3、 由于 wait()、notify/notifyAll() 在synchronized 代码块执行，说明当前线程一定是获取了锁的。
当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
也就是说，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。所以在编程中，尽量在使用了notify/notifyAll() 后立即退出临界区，以唤醒其他线程让其获得锁

4、wait() 需要被try catch包围，以便发生异常中断也可以使wait等待的线程唤醒。
5、notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的。
6、notify 和 notifyAll的区别
notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，
选择哪个线程取决于操作系统对多线程管理的实现。notifyAll 会唤醒所有等待(对象的)线程，尽管哪一个线程将会第一个处理取决于操作系统的实现。
如果当前情况下有多个线程需要被唤醒，推荐使用notifyAll 方法。比如在生产者-消费者里面的使用，每次都需要唤醒所有的消费者或是生产者，以判断程序是否可以继续往下执行。

7、在多线程中要测试某个条件的变化，使用if 还是while？

要注意，notify唤醒沉睡的线程后，线程会接着上次的执行继续往下执行。所以在进行条件判断时候，可以先把 wait 语句忽略不计来进行考虑；
显然，要确保程序一定要执行，并且要保证程序直到满足一定的条件再执行，要使用while进行等待，直到满足条件才继续往下执行
 */
class FooBar6 {
    private int n;
    private final Object obj = new Object();
    private volatile boolean fooExec = true;

    public FooBar6(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                while (!fooExec) {//fooExec为false时，该线程等待，为true的时候执行下面的操作
                    obj.wait();
                }
                printFoo.run();
                fooExec = false;
                obj.notifyAll();//唤醒其他线程
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                while (fooExec) {
                    obj.wait();
                }
                printBar.run();
                fooExec = true;
                obj.notifyAll();
            }

        }
    }
}

/*
方法7:LockSupport
背景知识

    LockSupport类的核心方法其实就两个：park()和unpark()，其中park()方法用来阻塞当前调用线程，unpark()方法用于唤醒指定线程。
    这其实和Object类的wait()和signal()方法有些类似，但是LockSupport的这两种方法从语意上讲比Object类的方法更清晰，而且可以针对指定线程进行阻塞和唤醒。

    LockSupport类使用了一种名为Permit（许可）的概念来做到阻塞和唤醒线程的功能，可以把许可看成是一种(0,1)信号量（Semaphore），
    但与 Semaphore 不同的是，许可的累加上限是1。
    初始时，permit为0，当调用unpark()方法时，线程的permit加1，当调用park()方法时，如果permit为0，则调用线程进入阻塞状态。
 */
class FooBar7 {
    private int n;
    private Map<String, Thread> map = new ConcurrentHashMap<>();
    private volatile boolean fooExec = true;

    public FooBar7(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                LockSupport.park();
            }
            printFoo.run();
            fooExec = false;
            LockSupport.unpark(map.get("bar"));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (fooExec) {
                LockSupport.park();
            }
            printBar.run();
            fooExec = true;
            LockSupport.unpark(map.get("foo"));
        }
    }
}