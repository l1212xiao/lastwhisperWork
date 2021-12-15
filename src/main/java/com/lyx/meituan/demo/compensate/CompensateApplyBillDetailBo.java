package com.lyx.meituan.demo.compensate;

/**
 * @author lvyunxiao
 * @date 2021/11/29
 * @description
 */
public class CompensateApplyBillDetailBo {

    /**
     *   字段: compensate_qty
     *   说明: 买赔数量
     */
    private Long compensateQty;

    /**
     *   字段: price
     *   说明: 单价,单位：分
     */
    private Long price;

    /**
     *   字段: compensate_amount
     *   说明: 买赔金额，单位：分
     */
    private Long compensateAmount;

    public Long getCompensateQty() {
        return compensateQty;
    }

    public void setCompensateQty(Long compensateQty) {
        this.compensateQty = compensateQty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCompensateAmount() {
        return compensateAmount;
    }

    public void setCompensateAmount(Long compensateAmount) {
        this.compensateAmount = compensateAmount;
    }

    @Override
    public String toString() {
        return "CompensateApplyBillDetailBo{" +
            "compensateQty=" + compensateQty +
            ", price=" + price +
            ", compensateAmount=" + compensateAmount +
            '}';
    }
}
