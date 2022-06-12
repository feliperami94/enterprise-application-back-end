package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostProductUseCaseTest {

    @MockBean
    PostProductUseCase postProductUseCase;

    @Test
    void postProductUseCaseTest(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId("ProductIDTest");
        productDTO.setProductPrice(10.0);
        productDTO.setProductQuantity(5);
        productDTO.setProductName("Hammer");
        productDTO.setDescription("Big hammer with wooden handle");
        productDTO.setMaxQuantity(100);
        productDTO.setMinQuantity(3);
        productDTO.setProviderId("12345ID");

        StepVerifier.create(Mono.just(Mockito.when(postProductUseCase.postProduct(productDTO))
                .thenReturn(Mono.just(productDTO))))
                .expectNextCount(1)
                .expectComplete()
                .verify();



    }



}