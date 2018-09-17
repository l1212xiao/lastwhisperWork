package cn.lyx.StringOp;

/**
 * Created by lyx on 2018/8/8.
 * 字符串中字符删除ac和b
 */
public class InterviewDemo {
    public static void main(String[] args) {
        String string = "acbac";
        StringBuilder sb = new StringBuilder(string);

        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == 'b') { //发现b
                sb.delete(i, i + 1);  //删除
                if (i >= 1)
                    i--;
            } else {
                if (i < sb.length() - 1)
                    if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'c') {  //发现ac
                        sb.delete(i, i + 2);   //删除
                        if (i >= 1)
                            i--;
                        continue;
                    }
                i++;
            }
        }
        System.out.println(sb.toString());
    }
}
