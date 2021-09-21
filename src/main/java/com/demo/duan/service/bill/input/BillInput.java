package com.demo.duan.service.bill.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class BillInput {

    @NotBlank(message = "Không được để trống!")
    @Email(message = "Email có dạng exemple@gmail.com")
    private String email;

    @NotBlank(message = "Không được để trống!")
    private String name;

    @NotNull(message = "Không được để trống!")
    @Positive(message = "SĐT phải là chữ số")
    private String phone;

    @NotNull(message = "Không được bỏ trống!")
    private String address;
    @NotBlank(message = "Không được để trống!")
    private String city;
    @NotBlank(message = "Không được để trống!")
    private String district;

}
