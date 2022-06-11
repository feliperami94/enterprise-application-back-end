package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "receipt")
@Data
public class Receipt {
    @Id
    private String receiptId;
    private String productQuantity;
    private String receiptProductId;
    private String receiptDate;
    private String providerId;
}
