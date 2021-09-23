package com.demo.duan.controller.bill;

import com.demo.duan.service.bill.BillService;
import com.demo.duan.service.bill.dto.BillDto;
import com.demo.duan.service.bill.input.BillInput;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/bill")
public class BillRest {

    private final BillService billService;

    // get all bill done
    @GetMapping("/getbill")
    public ResponseEntity<Page<BillDto>> getOne(@RequestParam("page") Optional<Integer> p){
        PageRequest pageable = PageRequest.of(p.orElse(0), 10);
        return billService.getAll(pageable);
    }

    // create bill
    @PostMapping("/create")
    public ResponseEntity<BillDto> createBill(@RequestBody BillInput input){
        return billService.create(input);
    }

    // update bill by id bill
    @PutMapping("/update/{id}")
    public ResponseEntity<BillDto>updateBillById(@RequestBody BillInput input, @PathVariable("id") Integer id){
        return billService.update(input, id);
    }
}
