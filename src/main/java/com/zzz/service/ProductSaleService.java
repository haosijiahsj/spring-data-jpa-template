package com.zzz.service;

import com.zzz.domain.ProductSalePo;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/7.
 */
public interface ProductSaleService {
    void batchSave(List<ProductSalePo> productSales);
}
