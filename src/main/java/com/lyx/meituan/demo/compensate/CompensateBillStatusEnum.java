package com.lyx.meituan.demo.compensate;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2021/11/30
 * @description
 */
public enum CompensateBillStatusEnum  {

    /**
     * 新建
     */
    CREATED(10, "新建"),

    /**
     * 审批中
     */
    APPROVING(20, "审批中"),

    /**
     * 审核驳回
     */
    AUDIT_REJECT(21, "审核驳回"),

    /**
     * 商家待确认
     */
    SUPPLIER_WAIT_CONFIRM(22, "商家待确认"),

    /**
     * 商家驳回
     */
    SUPPLIER_REJECT(30, "商家驳回"),

    /**
     * 商家已确认
     */
    SUPPLIER_CONFIRM(31, "商家已确认"),

    /**
     * 待支付
     */
    WAIT_PAY(40, "待支付"),

    /**
     * 已付款
     */
    ALREADY_PAY(41, "已付款"),

    /**
     * 待出库
     */
    WAITING_OUT(50, "待出库"),

    /**
     * 已完成
     */
    IN_SUCCESS(60, "已完成"),

    /**
     * 已关闭
     */
    CLOSE(99, "已关闭"),

    ;

    /**
     * Code
     */
    private int code;

    /**
     * 名称
     */
    private String name;

    /**
     * 构造方法
     *
     * @param code CODE
     * @param name 名称
     */
    CompensateBillStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
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

    public int getCode() {
        return code;
    }

    /**
     * CODE -> ENUM 映射表
     */
    private static final Map<Integer, CompensateBillStatusEnum> CODE_2_MAP = Maps.newHashMap();

    /**
     * 映射表初始化
     */
    static {
        for (CompensateBillStatusEnum statusEnum : CompensateBillStatusEnum.values()) {
            CODE_2_MAP.put(statusEnum.getCode(), statusEnum);
        }
    }

    /**
     * 获取枚举
     *
     * @param code CODE
     * @return 枚举
     */
    public static CompensateBillStatusEnum codeOf(Integer code) {
        return CODE_2_MAP.get(code);
    }

    public static void main(String[] args) {
        for (CompensateBillStatusEnum statusEnum : CompensateBillStatusEnum.values()) {
            System.out.println(statusEnum.toString().toLowerCase());
        }

    }


}

