package com.demo.duan.repository.billdetail;

import com.demo.duan.entity.BillDetailEntity;
import com.demo.duan.service.billdetail.dto.BillDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Integer> {
//    @Query("SELECT o FROM BillDetailEntity o WHERE o.bill.id=:id")
//    Page<BillDetailEntity> findByBill_Id(@Param("id") Integer id);
}
