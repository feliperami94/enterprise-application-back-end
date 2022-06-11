package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document(collection = "bill")
@Data
public class Bill {
    @Id
    private String billId;
    private String billDate;
    private String clientName;
    private String sellerName;
    private Map<String, Integer> productList;
    private Double totalPaid;


}
