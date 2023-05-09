package com.lyx.interview.interview2023;

import java.util.HashMap;
import java.util.Map;

/*
这是一道2023电信二面的面试题，因为差一点完整无误的做出来，可能是导致面试失败的原因
后来冷静下来，只是少想了一点点而且
虽然面试不代表什么，但是有时候，多想一点，可能结局不一样呢？
*/

/*
public static void main(String[] args) {
    Map<String, Object> input = new HashMap<>();
    input.put("a", 1);
    {
        Map<String, Object> b = new HashMap<>();
        input.put("b", b);
        b.put("x", 1);
        {
            Map<String, Object> c = new HashMap<>();
            b.put("c", c);
            c.put("y", 1);
        }
        {
            Map<String, Object> d = new HashMap<>();
            b.put("d", d);

            {
                Map<String, Object> e = new HashMap<>();
                d.put("e", e);
                e.put("o", 1);
            }
            d.put("f", 1);
        }
    }
    Map x = xxxxx
    System.out.println(x);
}

{a=1, b={c={y=1}, d={e={o=1}, f=1}, x=1}}
{a=1, b.c.y=1, b.d.e.o=1, b.d.f=1, b.x=1}

 */
public class Interview {

    public static Map<String, Object> trans(Map<String, Object> input) {
        Map<String, Object> result = new HashMap<>();
        dfs(input, result, "");
        return result;
    }

    public static void dfs(Map<String, Object> input,
                    Map<String, Object> result,
                    String path
                    ) {
        for (Map.Entry<String, Object> entry : input.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String newPath = "".equals(path) ? key : (path + "." + key);
            if (!(value instanceof Map)) {
                result.put(newPath, value);
            } else {
                dfs((Map<String, Object>) value, result, newPath);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Object> input = new HashMap<>();
        input.put("a", 1);
        {
            Map<String, Object> b = new HashMap<>();
            input.put("b", b);
            b.put("x", 1);
            {
                Map<String, Object> c = new HashMap<>();
                b.put("c", c);
                c.put("y", 1);
            }
            {
                Map<String, Object> d = new HashMap<>();
                b.put("d", d);

                {
                    Map<String, Object> e = new HashMap<>();
                    d.put("e", e);
                    e.put("o", 1);
                }
                d.put("f", 1);
            }
        }
        Map x = trans(input);
        System.out.println(x);
    }


}
