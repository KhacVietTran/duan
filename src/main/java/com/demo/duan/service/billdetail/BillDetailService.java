package com.demo.duan.service.billdetail;

import com.demo.duan.service.billdetail.dto.BillDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BillDetailService {
    ResponseEntity<Page<BillDetailDto>>getAll(Pageable pageable);

    ResponseEntity<BillDetailDto> getByIdBill(Integer id);
}
