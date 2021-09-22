package com.demo.duan.service.cartdetail;

import com.demo.duan.entity.CartDetailEntity;
import com.demo.duan.entity.ProductEntity;
import com.demo.duan.repository.cartdetail.CartDetailRepository;
import com.demo.duan.service.cartdetail.dto.CartDetailDto;
import com.demo.duan.service.cartdetail.input.CartDetailInput;
import com.demo.duan.service.cartdetail.mapper.CartDetailMapper;
import com.demo.duan.service.cartdetail.param.CartDetailParam;
import com.demo.duan.service.product.dto.ProductDto;
import com.demo.duan.service.product.param.ProductParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CartDetailServiceImpl implements CartDetailService{

    private final CartDetailRepository repository;

    private final CartDetailMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<List<CartDetailDto>> find(CartDetailParam param) {
        List<CartDetailEntity> lst = repository.find(param);
        List<CartDetailDto> lstDto =mapper.EntitiesToDtos(lst);
        return ResponseEntity.ok().body(lstDto);
    }

    @Override
    @Transactional
    public ResponseEntity<CartDetailDto> addToCartDetail(CartDetailInput input) {
        CartDetailEntity entity = repository.findByCart_Id(input.getCartId());
        Integer count = repository.countAllByCart_IdAndProduct_Id(input.getCartId(), input.getProductId());
        Integer numberOfCart = entity.getProduct().getNumber();
        if(count > 0){
//            entity.getProduct().setNumber(inp);
        }
        System.out.println(numberOfCart);
        return null;
    }
}
