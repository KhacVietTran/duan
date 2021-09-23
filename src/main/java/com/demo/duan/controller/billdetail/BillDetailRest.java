package com.demo.duan.controller.billdetail;

import com.demo.duan.service.billdetail.BillDetailService;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/bill-detail")
public class BillDetailRest {
    private final BillDetailService service;
//    @GetMapping("/get")
//    public ResponseEntity<Page<BillDetailDto>>getAll(@RequestParam("page") Pageable pageable, @RequestParam("billid") Integer billId){
//        return service.getByIdBill(pageable, billId);
//    }
}
