package com.lyx.meituan.hashTest;

/**
 * @author lvyunxiao
 * @date 2021/3/9
 * @description
 */
public class SupplierSku {
    private long skuId;
    private long supplierId;

    public SupplierSku() {
    }

    public SupplierSku(long skuId, long supplierId) {
        this.skuId = skuId;
        this.supplierId = supplierId;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

}
