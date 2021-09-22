package com.demo.duan.service.cartdetail.input;

import com.demo.duan.entity.CartEntity;
import com.demo.duan.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartDetailInput {
    private Integer cartId;

    private Integer productId;

    private Integer number;

}
