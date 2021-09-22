package com.demo.duan.service.cartdetail;

import com.demo.duan.entity.CartDetailEntity;
import com.demo.duan.entity.CartEntity;
import com.demo.duan.entity.ProductEntity;
import com.demo.duan.repository.cart.CartRepository;
import com.demo.duan.repository.cartdetail.CartDetailRepository;
import com.demo.duan.repository.product.ProductRepository;
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

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartDetailServiceImpl implements CartDetailService{

    private final CartDetailRepository repository;

    private final CartDetailMapper mapper;

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

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

        /* Lấy thông tin sản phẩm */
        ProductEntity product = productRepository.getById(input.getProductId());

        /* Lấy thông tin Giỏ hàng */
        CartEntity cartEntity = cartRepository.getById(input.getCartId());

        /* Lấy giá sản phẩm */
        BigDecimal price = product.getPrice();
        BigDecimal total= BigDecimal.ZERO;

        /* Kiểm tra sản phẩm đã có sẵn trong Giỏ hàng chưa */
        Integer count = repository.countAllByCart_IdAndProduct_Id(input.getCartId(), input.getProductId());

        /* Nếu có r thì cập nhật số lượng và tổng tiền */
        if(count > 0){
            /* Lấy thông tin giỏ hàng chi tiết */
            CartDetailEntity entity = repository.findByCart_IdAndProduct_Id(input.getCartId(), input.getProductId());

            /* Tăng số lượng trong giỏ hàng chi tiết */
            Integer number = input.getNumber() + entity.getNumber();

            /* Tính lại tổng tiền từng sản phẩm */
            total = price.multiply(BigDecimal.valueOf(number));
            mapper.inputToEntity(input, entity);

            /* Lưu thông tin giỏ hàng chi tiết */
            entity.setNumber(count);
            entity.setTotal(total);
            entity.setNumber(number);
            repository.save(entity);
            return ResponseEntity.ok().body(mapper.entityToDto(entity));
        }

        /* Thêm sản phẩm mới vào giỏ */
        else{
            CartDetailEntity entity = mapper.inputToEntity(input);
            entity.setProduct(product);
            entity.setCart(cartEntity);

            /* Tính tổng tiền sản phẩm vừa thêm vào */
            total= price.multiply(BigDecimal.valueOf(input.getNumber()));

            /* Lưu giỏ hàng chi tiết */
            entity.setTotal(total);
            repository.save(entity);
            return ResponseEntity.ok().body(mapper.entityToDto(entity));
        }
    }
}
