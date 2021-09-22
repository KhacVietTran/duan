package com.demo.duan.service.billdetail.input;

import com.demo.duan.entity.BillEntity;
import com.demo.duan.entity.ProductEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class BillDetailInput {
    @NotBlank(message = "Không được để trống")
    private ProductEntity product;

    private BillEntity bill;
    @NotNull(message = "Không được để trống")
    private Integer number;

    private BigDecimal price;

    private BigDecimal total;
}
