package com.lyx.meituan.hashTest;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.lyx.utils.FastJsonUtils;
import java.util.Set;
import org.junit.Test;

/**
 * @author lvyunxiao
 * @date 2021/3/9
 * @description
 */
public class SetsHashDemo {
    @Test
    public void setUnionTestNoHash() {

        final Set<SupplierSku> inOutRecordKey = Sets.newHashSet();
        inOutRecordKey.add(new SupplierSku(1L,2L));
        inOutRecordKey.add(new SupplierSku(1L,2L));
        inOutRecordKey.add(new SupplierSku(11L,22L));
        inOutRecordKey.add(new SupplierSku(111L,222L));

        final Set<SupplierSku> detailKey =Sets.newHashSet();
        detailKey.add(new SupplierSku(1L,2L));
        detailKey.add(new SupplierSku(11L,22L));
        detailKey.add(new SupplierSku(1111L,2222L));

        final SetView<SupplierSku> skuKeys = Sets.intersection(inOutRecordKey, detailKey);
        for (SupplierSku skuKey : skuKeys) {
            final String toJson = FastJsonUtils.toJSONStr(skuKey);
            System.out.println(toJson);

        }
    }

    @Test
    public void setUnionTestWithHash() {

        final Set<SupplierSkuKey> inOutRecordKey = Sets.newHashSet();
        inOutRecordKey.add(new SupplierSkuKey(1L,2L));
        inOutRecordKey.add(new SupplierSkuKey(1L,2L));
        inOutRecordKey.add(new SupplierSkuKey(11L,22L));
        inOutRecordKey.add(new SupplierSkuKey(111L,222L));

        final Set<SupplierSkuKey> detailKey =Sets.newHashSet();
        detailKey.add(new SupplierSkuKey(1L,2L));
        detailKey.add(new SupplierSkuKey(11L,22L));
        detailKey.add(new SupplierSkuKey(1111L,2222L));

        // 交集
        final SetView<SupplierSkuKey> skuKeys = Sets.intersection(inOutRecordKey, detailKey);
        for (SupplierSkuKey skuKey : skuKeys) {
            System.out.println(skuKey.toString());
        }

        // 并集
        final SetView<SupplierSkuKey> unionSkuKeys = Sets.union(inOutRecordKey, detailKey);
        for (SupplierSkuKey skuKey : unionSkuKeys) {
            System.out.println(skuKey.toString());
        }

    }
}
