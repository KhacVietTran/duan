package com.demo.duan.service.billdetail;

import com.demo.duan.entity.BillDetailEntity;
import com.demo.duan.repository.billdetail.BillDetailRepository;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import com.demo.duan.service.billdetail.input.BillDetailInput;
import com.demo.duan.service.billdetail.mapper.BillDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillDetailServiceImpl implements BillDetailService{
    private final BillDetailRepository billDetailRepository;
    private final BillDetailMapper mapper;

    @Override
    public ResponseEntity<Page<BillDetailDto>> getByIdBill(Integer id, Pageable pageable) {
        Page<BillDetailDto> result = billDetailRepository.findByBill_Id(id, pageable).map(mapper :: entityToDto);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<BillDetailDto> createBillDetail(BillDetailInput input) {
        BillDetailEntity entity = this.mapper.inputToEntity(input);
        this.billDetailRepository.save(entity);
        return ResponseEntity.ok().body(this.mapper.entityToDto(entity));
    }

}
