package com.demo.duan.controller.billdetail;

import com.demo.duan.service.billdetail.BillDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bill-detail")
public class BillDetailRest {
    private final BillDetailService service;
    @GetMapping("index")
    public String index(){
        service.getByIdBill(1);
        return "thuan dep trai vcl";
    }
}
