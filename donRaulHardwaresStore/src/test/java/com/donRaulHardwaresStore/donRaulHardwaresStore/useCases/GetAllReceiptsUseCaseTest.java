package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Receipt;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ReceiptMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IReceiptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllReceiptsUseCaseTest {

    @Mock
    IReceiptRepository iReceiptRepository;

    @Autowired
    private ReceiptMapper receiptMapper;

    private GetAllReceiptsUseCase getAllReceiptsUseCase;

    @BeforeEach
    void beforeEach(){
        getAllReceiptsUseCase = new GetAllReceiptsUseCase(iReceiptRepository, receiptMapper);
    }

    @Test
    void getAllReceiptsTest() {
        Provider provider = new Provider();
        provider.setProviderId("12345");
        provider.setProviderName("TestProvider");
        provider.setProviderPhone("311382");
        provider.setProviderPassport("ABC123");
        provider.setAvailability(true);

        Product product = new Product();
        product.setProductId("productTestID");

        Receipt receipt = new Receipt();
        receipt.setReceiptId("receiptTestID");
        receipt.setProductQuantity("5");
        receipt.setReceiptProductId(product.getProductId());
        receipt.setReceiptDate("11-06-2022");
        receipt.setProviderId(provider.getProviderId());


        Mockito.when(iReceiptRepository.findAll()).thenReturn(Flux.just(receipt));
        Flux<ReceiptDTO> receiptDTOFlux = getAllReceiptsUseCase.getReceipts();

        StepVerifier.create(receiptDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(iReceiptRepository).findAll();
    }



}