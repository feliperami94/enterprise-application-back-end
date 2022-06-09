package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class BillDTO {
    private String billId;
    private LocalDate billDate;
    private String clientName;
    private String sellerName;
    private List<ProductDTO> productList;
    private Double totalPaid;

}
