package com.nurbb.product_service.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// Entity
@Entity(name="Product")
@Table(name="product")
public class ProductEntity extends BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    //@Column(name = "product_name",unique = true,nullable = false,insertable = true,updatable = true)
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_quantify")
    private String productQuantify;

} //end ProductEntity
