package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private Integer productQuantity;
    private Integer productPrice;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String description;
    private String providerId;
}
