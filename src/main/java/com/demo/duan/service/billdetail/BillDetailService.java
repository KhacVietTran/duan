package com.demo.duan.service.billdetail;

import com.demo.duan.service.billdetail.dto.BillDetailDto;
import com.demo.duan.service.billdetail.input.BillDetailInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface BillDetailService {
    ResponseEntity<Page<BillDetailDto>> getByIdBill(Integer id, Pageable pageable);
    ResponseEntity<BillDetailDto>createBillDetail(BillDetailInput input);
}
