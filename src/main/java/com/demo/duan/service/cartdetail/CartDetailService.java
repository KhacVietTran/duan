package com.demo.duan.service.cartdetail;

import com.demo.duan.entity.ProductEntity;
import com.demo.duan.service.cartdetail.dto.CartDetailDto;
import com.demo.duan.service.cartdetail.input.CartDetailInput;
import com.demo.duan.service.cartdetail.param.CartDetailParam;
import com.demo.duan.service.product.dto.ProductDto;
import com.demo.duan.service.product.param.ProductParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartDetailService {
    public ResponseEntity<List<CartDetailDto>> find(CartDetailParam param);

    public ResponseEntity<CartDetailDto> addToCartDetail(CartDetailInput input);
}
