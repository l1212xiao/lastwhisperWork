package com.lyx.meituan.groupBy.apple;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lvyunxiao
 * @date 2021/3/8
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 总数
     */
    private Long count;

    /**
     * 类别
     */
    private String type;

}
