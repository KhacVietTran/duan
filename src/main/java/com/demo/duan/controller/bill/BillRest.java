package com.demo.duan.controller.bill;

import com.demo.duan.service.bill.BillService;
import com.demo.duan.service.bill.dto.BillDto;
import com.demo.duan.service.bill.input.BillInput;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillRest {

    private final BillService billService;

    @GetMapping("/getbill")
    public ResponseEntity<Page<BillDto>> getOne(@RequestParam("page") Optional<Integer> p){
        PageRequest pageable = PageRequest.of(p.orElse(0), 100);
        return billService.getByName("thuan", pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<BillDto> createBill(@RequestBody BillInput input){
        return billService.create(input);
    }
}
