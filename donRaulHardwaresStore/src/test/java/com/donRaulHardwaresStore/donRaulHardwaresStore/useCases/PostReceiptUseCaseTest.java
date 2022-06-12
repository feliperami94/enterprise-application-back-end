package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Receipt;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostReceiptUseCaseTest {
    @MockBean
    PostReceiptUseCase postReceiptUseCase;

    @Test
    void postReceiptUseCaseTest(){
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setReceiptId("12345");
        receiptDTO.setReceiptDate("12-06-2022");
        receiptDTO.setReceiptProductId("ProductID1");
        receiptDTO.setProductQuantity("5");
        receiptDTO.setProviderId("ProviderID");

        StepVerifier.create(Mono.just(Mockito.when(postReceiptUseCase.postReceipt(receiptDTO))
                .thenReturn(Mono.just(receiptDTO))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}