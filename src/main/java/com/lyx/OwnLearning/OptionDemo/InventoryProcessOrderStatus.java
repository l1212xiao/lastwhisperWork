package com.lyx.OwnLearning.OptionDemo;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;

/**
 * @author lvyunxiao
 * @date 2021/10/22
 * @description
 */
public enum InventoryProcessOrderStatus {
    DISPATCHING("下发中", 1),
    WAIT_HADNLE("待处理", 3),
    OUT_STORE("已完成", 4),
    CLOSE("已关闭", 5),
    WAIT_APPROVE("待审批", 20),
    WAIT_PAY("待付款", 30),
    WAIT_CONFIRM("待确认", 40),
    ;

    private int code;

    private String name;

    InventoryProcessOrderStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    private static final Map<Integer, InventoryProcessOrderStatus> CODE2_MAP = Maps.newHashMap();

    static {
        for (InventoryProcessOrderStatus statusEnum : InventoryProcessOrderStatus
            .values()) {
            CODE2_MAP.put(statusEnum.getCode(), statusEnum);
        }
    }

    public static InventoryProcessOrderStatus codeOf(Integer code) {
        return CODE2_MAP.get(code);
    }

    public static String getNameByCode(Integer code) {
        Optional<InventoryProcessOrderStatus> statusOptional = Optional.ofNullable(CODE2_MAP.get(code));
        if (statusOptional.isPresent()) {
            return statusOptional.get().getName();
        } else {
            return "未知";
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
