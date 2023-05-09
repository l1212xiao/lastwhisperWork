package com.lyx.OwnLearning.threadlocal;

/**
 * @author lvyunxiao
 * @date 2023/5/9
 */
public class ThreadLocalDemo {

	private static ThreadLocal<String> localVar = new ThreadLocal<>();

	static void print(String str) {
		// 打印当前线程中本地内存中本地变量的值
		System.out.println(str + " :" + localVar.get());
		// 清除本地内存中的本地变量
		localVar.remove();
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadLocalDemo.localVar.set("local_A");
				ThreadLocalDemo.localVar.set("local_A1");
				print("A");
				System.out.println("after remove : " + localVar.get());
			}
		},"A").start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadLocalDemo.localVar.set("local_B");
				print("B");
				System.out.println("after remove : " + localVar.get());
			}
		}, "B").start();

	}

}
