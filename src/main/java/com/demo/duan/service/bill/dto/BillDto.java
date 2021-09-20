package com.demo.duan.service.bill.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BillDto {
    private Integer id;
    private Date create_date;
    private Date update_date;
    private String name;
    private String phone;
    private Double total;
    private int status_pay;
    private String address;
    private String city;
    private String district;
    private int status_order;
    private String discount;
    private String describe;
    private String thema;
    private String themb;
    private String themc;
}
