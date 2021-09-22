package com.demo.duan.service.bill;

import com.demo.duan.entity.BillEntity;
import com.demo.duan.repository.bill.BillRepository;
import com.demo.duan.repository.staff.StaffRepository;
import com.demo.duan.service.bill.dto.BillDto;
import com.demo.duan.service.bill.input.BillInput;
import com.demo.duan.service.bill.mapper.BillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceimpl implements BillService{

    private final BillRepository billRepository;

    private final StaffRepository staffRepository;

    private final BillMapper billMapper;
    @Override
    public ResponseEntity<Page<BillDto>> getAll(Pageable pageable) {
        Page <BillDto> result = this.billRepository.findAll(pageable).map(billMapper :: entityToDto);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<BillDto> getOne(Integer id) {
        BillEntity entity = this.billRepository.findById(id).orElseThrow(() -> new RuntimeException("id không tồn tại!"));
        return ResponseEntity.ok().body(this.billMapper.entityToDto(entity));
    }

    @Override
    public ResponseEntity<Page<BillDto>> getByName(String name, Pageable pageable) {
        Page<BillDto> result = this.billRepository.findByName(name,pageable).map(billMapper :: entityToDto);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<BillDto> create(BillInput input) throws RuntimeException{
        BillEntity entity = this.billMapper.inputToEntity(input);
        Date date = new Date();
        entity.setCreate_date(date);
        BigDecimal bd = new BigDecimal(String.valueOf(input.getTotal()));
        entity.setTotal(bd);
        entity.setStaff(staffRepository.getById(input.getStaff()));
        this.billRepository.save(entity);
        return ResponseEntity.ok().body(this.billMapper.entityToDto(entity));
    }

    @Override
    public ResponseEntity<BillDto> update(BillInput input, Integer id) throws RuntimeException{
        BillEntity entity = this.billRepository.findById(id).orElseThrow(() -> new RuntimeException("Không có hóa đơn này"));
        this.billMapper.inputToEntity(input, entity);
        this.billRepository.save(entity);
        return ResponseEntity.ok().body(this.billMapper.entityToDto(entity));
    }

    @Override
    public ResponseEntity<BillDto> delete(Integer id) {
        BillEntity entity = this.billRepository.getById(id);
        String status_oder = entity.getStatus_order();
        if (status_oder == "ok"){
            entity.setStatus_order("not ok");
        }else {
            entity.setStatus_order("not ok");
        }
        this.billRepository.save(entity);
        return ResponseEntity.ok().body(this.billMapper.entityToDto(entity));
    }
}
