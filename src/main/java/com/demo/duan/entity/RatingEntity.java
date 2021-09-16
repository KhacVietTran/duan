package com.demo.duan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rating")
public class RatingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(name="date_create")
    private Date create_date;

    @Column(name="star")
    private Integer star;

    @Column(name="describe")
    private String describe;
}
