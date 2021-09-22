package com.demo.duan.service.billdetail.dto;

import com.demo.duan.entity.BillEntity;
import com.demo.duan.entity.ProductEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDetailDto {
    private Integer id;

    private ProductEntity product;

    private BillEntity bill;

    private Integer number;

    private BigDecimal price;

    private BigDecimal total;
}
