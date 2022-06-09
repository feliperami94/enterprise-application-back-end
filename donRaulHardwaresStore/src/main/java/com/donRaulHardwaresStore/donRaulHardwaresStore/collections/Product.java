package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "product")
@Data
public class Product {
    @Id
    private String productId;
    private String productName;
    private Integer productQuantity;
    private Double productPrice;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String description;
    private String providerID;
}
