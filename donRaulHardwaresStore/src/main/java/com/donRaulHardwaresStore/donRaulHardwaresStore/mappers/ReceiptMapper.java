package com.donRaulHardwaresStore.donRaulHardwaresStore.mappers;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Receipt;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {
    private final ModelMapper receiptMapper;


    public ReceiptMapper(ModelMapper receiptMapper) {
        this.receiptMapper = receiptMapper;
    }

    public ReceiptDTO receiptToReceiptDTO(Receipt receipt){return receiptMapper.map(receipt, ReceiptDTO.class);}
    public Receipt receiptDTOToReceipt(ReceiptDTO receiptDTO){return receiptMapper.map(receiptDTO, Receipt.class);}
}
