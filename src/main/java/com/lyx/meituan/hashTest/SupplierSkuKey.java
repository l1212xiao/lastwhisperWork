package com.lyx.meituan.hashTest;

import java.util.Objects;

/**
 * @author lvyunxiao
 * @date 2021/3/9
 * @description
 */
public class SupplierSkuKey {
    private long skuId;
    private long supplierId;

    public SupplierSkuKey() {
    }

    public SupplierSkuKey(long skuId, long supplierId) {
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

    @Override
    public String toString() {
        return "SupplierSkuKey{" +
            "skuId=" + skuId +
            ", supplierId=" + supplierId +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupplierSkuKey that = (SupplierSkuKey) o;
        return skuId == that.skuId &&
            supplierId == that.supplierId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, supplierId);
    }

}
