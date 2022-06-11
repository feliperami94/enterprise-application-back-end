package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;


import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ReceiptMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllReceiptsUseCase {
    private final IReceiptRepository iReceiptRepository;
    private final ReceiptMapper receiptMapper;

    public GetAllReceiptsUseCase(IReceiptRepository iReceiptRepository, ReceiptMapper receiptMapper){
        this.iReceiptRepository = iReceiptRepository;
        this.receiptMapper = receiptMapper;
    }

    public Flux<ReceiptDTO> getReceipts(){
        return iReceiptRepository.findAll().map(receiptMapper::receiptToReceiptDTO);
    }
}
