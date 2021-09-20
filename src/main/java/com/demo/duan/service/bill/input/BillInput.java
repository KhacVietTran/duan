package com.demo.duan.service.bill.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BillInput {
    @NotBlank(message = "name is not null")
    private String name;
}
