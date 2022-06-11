package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.BillMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IBillRepository;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllBillsUseCase {
    private final IBillRepository iBillRepository;
    private final BillMapper billMapper;

    public GetAllBillsUseCase(IBillRepository iBillRepository, BillMapper billMapper){
        this.iBillRepository = iBillRepository;
        this.billMapper = billMapper;
    }

    public Flux<BillDTO> getBills(){
        return iBillRepository.findAll().map(billMapper::billToBillDTO);
    }
}
