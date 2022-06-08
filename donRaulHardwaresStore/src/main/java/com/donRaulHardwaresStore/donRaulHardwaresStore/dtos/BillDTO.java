package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class BillDTO {
    private String id;
    private LocalDate date;
    private String clientName;
    private String sellerName;
    private List<Product> productList;
    private Double totalPaid;

}
