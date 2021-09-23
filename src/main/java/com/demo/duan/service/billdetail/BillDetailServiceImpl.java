package com.demo.duan.service.billdetail;

import com.demo.duan.repository.billdetail.BillDetailRepository;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import com.demo.duan.service.billdetail.mapper.BillDetailMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    public ResponseEntity<Page<BillDetailDto>> getByIdBill(Pageable pageable, Integer id) {
//        Page<BillDetailDto> result = billDetailRepository.findByBill_Id(id).map(mapper :: entityToDto);
        return null;
    }
}
