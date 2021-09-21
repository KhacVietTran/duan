package com.demo.duan.service.bill;

import com.demo.duan.service.bill.dto.BillDto;
import com.demo.duan.service.bill.input.BillInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BillService {
    ResponseEntity<Page<BillDto>>getAll(Pageable pageable);

    ResponseEntity<BillDto>getOne(Integer id);

    ResponseEntity<BillDto>create(BillInput input);

    ResponseEntity<BillDto>update(BillInput input, Integer id);

    ResponseEntity<BillDto>delete(Integer id);
}
