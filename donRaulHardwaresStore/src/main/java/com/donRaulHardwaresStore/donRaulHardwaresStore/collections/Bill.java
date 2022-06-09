package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "bill")
@Data
public class Bill {
    @Id
    private String billId;
    private LocalDate date;
    private String clientName;
    private String sellerName;
    private List<Product> productList;
    private Double totalPaid;


}
