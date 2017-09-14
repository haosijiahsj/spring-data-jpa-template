package com.zzz.service.impl;

import com.zzz.dao.ProductSaleRepository;
import com.zzz.domain.ProductSalePo;
import com.zzz.service.ProductSaleService;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/7.
 */
public class ProductSaleServiceImpl implements ProductSaleService {

    private ProductSaleRepository productSaleRepository;

    @Override
    public void batchSave(List<ProductSalePo> productSales) {
        productSaleRepository.save(productSales);
    }
}
