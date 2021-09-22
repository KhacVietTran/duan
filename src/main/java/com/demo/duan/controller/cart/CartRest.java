package com.demo.duan.controller.cart;

import com.demo.duan.service.cart.CartService;
import com.demo.duan.service.cart.dto.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class CartRest {

    private final CartService service;

    @GetMapping
    public ResponseEntity<CartDto> searchByCustomerId(@PathVariable Integer customerId){
        System.out.println(customerId);
        return null;
//        return service.searchByCustomerId(customerId);
    }
}
