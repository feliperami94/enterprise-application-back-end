package com.donRaulHardwaresStore.donRaulHardwaresStore.mappers;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Bill;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {
    private final ModelMapper billMapper;


    public BillMapper(ModelMapper billMapper) {
        this.billMapper = billMapper;
    }

    public BillDTO billToBillDTO(Bill bill){return billMapper.map(bill, BillDTO.class);}
    public Bill billDTOToBill(BillDTO billDTO){return billMapper.map(billDTO, Bill.class);}
}
