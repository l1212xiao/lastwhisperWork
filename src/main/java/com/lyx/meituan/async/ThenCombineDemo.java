package com.lyx.meituan.async;

import java.util.concurrent.CompletableFuture;
import org.junit.Test;

/**
 * @author lvyunxiao
 * @date 2021/3/24
 * @description
 * ref:
 * https://blog.csdn.net/baidu_30325009/article/details/91946439
 */
public class ThenCombineDemo {

    @Test
    public void thenCombine() throws Exception {
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            // delaySec(1);
            // printCurrTime("第一个CF");
            System.out.println("第一个CF");
            return "hello1";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // printCurrTime("第二个CF");
            // delaySec(3);
            System.out.println("第二个CF");
            return "hello2";
        }), (t, u) -> {
            // printCurrTime("组合");
            System.out.println("组合");
            return t + " " + u;
        });
        System.out.println(result.get());
    }


}
