package com.nurbb.product_service.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// Validation
public class ProductDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    private Long id;

    // NAME
    @NotEmpty(message = "{product.name.validation.NotNull.message}")
    private String productName;

    // PRICE : Fiyat
    @NotNull(message = "{product.price.validation.NotNull.message}")
    //@Size(min=1,max = 15, message = "{product.price.validation.constraints.NotNull.message}")
    private double productPrice;

    // Quantify: Ölçü
    @NotEmpty(message = "{product.quantify.validation.NotNull.message}")
    private String productQuantify;

    // Date
    @Builder.Default
    private Date createdDate= new Date(System.currentTimeMillis());
} //end ProductDto

