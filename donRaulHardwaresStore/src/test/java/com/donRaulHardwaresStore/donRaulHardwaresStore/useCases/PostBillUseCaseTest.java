package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostBillUseCaseTest {

    @MockBean
    PostBillUseCase postBillUseCase;

    @Test
    void postBillUseCaseTest(){
        Map<String, Integer> product= new HashMap<>();
        product.put("Product1", 1);
        product.put("Product2", 2);

        BillDTO billDTO = new BillDTO();
        billDTO.setBillId("BillIDTest");
        billDTO.setBillDate("12-06-2022");
        billDTO.setClientName("Luis");
        billDTO.setSellerName("Juan");
        billDTO.setProductList(product);
        billDTO.setTotalPaid(30.5);

        StepVerifier.create(Mono.just(Mockito.when(postBillUseCase.postBill(billDTO)).thenReturn(Mono.just(billDTO))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}