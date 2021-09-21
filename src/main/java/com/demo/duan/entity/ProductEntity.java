package com.demo.duan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private boolean status;

    @Column(name = "number")
    private Integer number;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "describe")
    private String describe;

    @Column(name = "photo")
    private String photo;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "create_date")
    private Date crate_date;

    @OneToMany(mappedBy = "product")
    private List<PhotoEntity> photos ;

    /* bảng chi tiết Tag*/
    @OneToMany(mappedBy = "product")
    private List<TagDetailEntity> tagDetails;


    /* Bảng Rating */
    @OneToMany(mappedBy = "product")
    private List<RatingEntity> ratings;
    
    /* Bảng hóa đơn chi tiết*/
    @OneToMany(mappedBy = "product")
    private List<BillDetailEntity> billDetails;

    @OneToMany(mappedBy = "product")
    private List<CartDetailEntity> cartDetails;

    /*Phiếu nhập chi tiết*/
    @OneToMany(mappedBy = "product")
    List<ReceiptDetailEntity> receiptDetails ;

}
