package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ReceiptDTO {
    private String id;
    private String providerName;
    private List<String> productList;
    private LocalDate receiptDate;
    private String providerId;
}
