package com.zzz.dao;

import com.zzz.domain.ProductSalePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by hushengjun on 2017/9/7.
 */
public interface ProductSaleRepository extends CrudRepository<ProductSalePo, Long> {

    @Query("SELECT ps FROM ProductSalePo ps WHERE ps.createTime >= ?1")
    Page<ProductSalePo> findProductSales(Date createTime, Pageable pageable);

}
