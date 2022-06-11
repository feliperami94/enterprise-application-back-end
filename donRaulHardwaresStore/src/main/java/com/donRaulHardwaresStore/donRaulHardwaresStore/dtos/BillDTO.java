package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class BillDTO {
    private String billId;
    private String billDate;
    private String clientName;
    private String sellerName;
    private Map<String, Integer> productList;
    private Double totalPaid;

}
