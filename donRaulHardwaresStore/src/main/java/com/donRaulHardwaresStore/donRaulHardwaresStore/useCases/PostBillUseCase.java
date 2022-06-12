package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.BillMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IBillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostBillUseCase {
    private final IBillRepository iBillRepository;
    private final BillMapper billMapper;

    public PostBillUseCase(IBillRepository iBillRepository, BillMapper billMapper){
        this.iBillRepository = iBillRepository;
        this.billMapper = billMapper;
    }

    public Mono<BillDTO> postBill(BillDTO billDTO){
        return iBillRepository.save(billMapper.billDTOToBill(billDTO)).map(billMapper::billToBillDTO);
    }
}
