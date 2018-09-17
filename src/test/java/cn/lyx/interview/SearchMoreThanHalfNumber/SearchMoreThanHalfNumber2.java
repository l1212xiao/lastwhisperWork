package cn.lyx.interview.SearchMoreThanHalfNumber;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/7/9.
 */
public class SearchMoreThanHalfNumber2 {
    public static int search(int[] nums) {
        //此方法不行
        //List<Integer> ints = Arrays.asList(nums);不可以将基本数据类型 asList

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {

            }
        }
        return 0;
    }
}
