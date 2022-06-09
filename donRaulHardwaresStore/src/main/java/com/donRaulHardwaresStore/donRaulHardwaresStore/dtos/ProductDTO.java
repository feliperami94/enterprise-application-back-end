package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private String description;
    private Integer productQuantity;
    private Double productPrice;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String providerId;
}
