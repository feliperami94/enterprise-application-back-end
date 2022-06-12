package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Bill;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.BillMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllBillsUseCaseTest {

    @Mock
    IBillRepository iBillRepository;

    @Autowired
    BillMapper billMapper;

    private GetAllBillsUseCase getAllBillsUseCase;

    @BeforeEach
    void beforeEach(){
        getAllBillsUseCase = new GetAllBillsUseCase(iBillRepository, billMapper);
    }

    @Test
    void getAllBillsUseCaseTest(){
        Map<String, Integer> product= new HashMap<>();
        product.put("Product1", 1);
        product.put("Product2", 2);

        Bill bill = new Bill();
        bill.setBillId("BillIDTest");
        bill.setBillDate("12-06-2022");
        bill.setClientName("Luis");
        bill.setSellerName("Juan");
        bill.setProductList(product);
        bill.setTotalPaid(15.0);

        Mockito.when(iBillRepository.findAll()).thenReturn(Flux.just(bill));
        Flux<BillDTO> billDTOFlux = getAllBillsUseCase.getBills();

        StepVerifier.create(billDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(iBillRepository).findAll();
    }

}