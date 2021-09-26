package com.demo.duan.controller.billdetail;

import com.demo.duan.service.billdetail.BillDetailService;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import com.demo.duan.service.billdetail.input.BillDetailInput;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/bill-detail")
public class BillDetailRest {
    private final BillDetailService service;
    @GetMapping("/get/{billid}")
    public ResponseEntity<Page<BillDetailDto>> getAll(@PathVariable("billid") Integer billId,
                         @RequestParam("page") Optional<Integer> p){
        PageRequest pageable = PageRequest.of(p.orElse(0), 10);
        return service.getByIdBill(billId, pageable);
    }
    @GetMapping("getok/{id}")
    public ResponseEntity<List<BillDetailDto>>getok(@PathVariable("id") Integer id){

        return null;
    }
    @PostMapping("create")
    public ResponseEntity<BillDetailDto> createBillDetail(@RequestBody BillDetailInput input){
        return null;
    }
}
