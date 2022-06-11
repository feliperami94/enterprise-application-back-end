package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ReceiptDTO {
    private String receiptId;
    private String productQuantity;
    private String receiptProductId;
    private String receiptDate;
    private String providerId;
}
