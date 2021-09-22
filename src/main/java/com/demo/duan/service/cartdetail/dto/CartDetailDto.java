package com.demo.duan.service.cartdetail.dto;

import com.demo.duan.entity.CartEntity;
import com.demo.duan.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartDetailDto {
    private ProductEntity product;

    private CartEntity cart;

    private Integer number;

    /*Thành tiền của tất cả sản phẩm trong phiếu nhập*/
    private BigDecimal total;
}
