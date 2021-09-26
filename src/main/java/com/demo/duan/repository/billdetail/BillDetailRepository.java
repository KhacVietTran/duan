package com.demo.duan.repository.billdetail;

import com.demo.duan.entity.BillDetailEntity;
demo.duan.service.billdetail.dto.BillDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< Updated upstream
        =======
import com.
import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Integer> {
<<<<<<< Updated upstream
=======
    @Query("SELECT b FROM BillDetailEntity b WHERE b.bill.id=:bid")
    Page<BillDetailEntity> findByBill_Id(@Param("bid") Integer bid, Pageable pageable);
>>>>>>> Stashed changes
}
