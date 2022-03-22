package com.lyx.OwnLearning.basicLearning;

/**
 * @author lvyunxiao
 * @date 2022/3/4
 * @description
 */
public class Test1 {

    // 总结：在方法中，如果参数传递的是基本数据类型的数据，则它传递的是值得副本，并不是值本身
    public static void main(String[] args) {
        int i = 1, j = 2;
        change(i, j);
        System.out.println("i=" + i + ",j=" + j);
        /**结果为：i=1,j=2*/
    }

    public static void change(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

}

class Test2 {

    // 总结： 如果方法中传递的是引用数据类型，则它传递的是引用（其实就是真正数据值所存放在内存中的地址值）的副本，
    // 也就是说，实质上如果修改的话，是对正真的值进行修改
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        change(numbers);
        System.out.println(numbers[0]); //结果为10
    }

    public static void change(int[] numbers) {
        numbers[0] = 10;
    }

    //可变参数类型其实也是一个数组（和上面的方法拥有同样的效果）
    public static void change1(int... numbers) {
        numbers[0] = 11;
    }

}

class Test3 {

    public static void main(String[] args) {
        T t = new T();
        change(t);
        System.out.println(t.i);  //输出的结果是1
    }

    public static void change(T t) { //此处传递的是上面对象引用的副本值
        // t = new T();    //此处在创建新对象时，将之前引用的副本值修改，所以在修改的时候，并没有修改以前的 值
        t.i = 10;
    }
}

class T {
    public int i = 1;
}
