package com.demo.duan.service.billdetail;

import com.demo.duan.repository.bill.BillRepository;
import com.demo.duan.repository.billdetail.BillDetailRepository;
import com.demo.duan.service.bill.dto.BillDto;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import com.demo.duan.service.billdetail.mapper.BillDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillDetailServiceImpl implements BillDetailService{
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;
    private final BillDetailMapper mapper;
    @Override
    public ResponseEntity<Page<BillDetailDto>> getAll(Pageable pageable) {
        Page <BillDetailDto> result = this.billDetailRepository.findAll(pageable).map(mapper :: entityToDto);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<BillDetailDto> getByIdBill(Integer id) {
        System.out.println("da vao chi tiet hoa don");
        return null;
    }
}
