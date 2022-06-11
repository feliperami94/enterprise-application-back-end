package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ReceiptMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostReceiptUseCase {
    private final IReceiptRepository iReceiptRepository;
    private final ReceiptMapper receiptMapper;

    public PostReceiptUseCase(IReceiptRepository iReceiptRepository, ReceiptMapper receiptMapper){
        this.iReceiptRepository = iReceiptRepository;
        this.receiptMapper = receiptMapper;
    }

    public Mono<ReceiptDTO> postReceipt(ReceiptDTO receiptDTO){
        return iReceiptRepository.save(receiptMapper.receiptDTOToReceipt(receiptDTO)).map(receiptMapper::receiptToReceiptDTO);
    }
}
