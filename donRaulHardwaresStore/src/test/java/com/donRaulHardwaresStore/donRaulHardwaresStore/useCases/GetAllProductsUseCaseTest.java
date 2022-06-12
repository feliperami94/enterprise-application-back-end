package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProductsUseCaseTest {
    @Mock
    IProductRepository iProductRepository;

    @Autowired
    ProductMapper productMapper;

    private GetAllProductsUseCase getAllProductsUseCase;

    @BeforeEach
    void beforeEach(){
        getAllProductsUseCase = new GetAllProductsUseCase(iProductRepository, productMapper);
    }

    @Test
    void getAllProductsTest(){
        Product product = new Product();
        product.setProductId("ProductIDTest");
        product.setProductPrice(50.0);
        product.setProductQuantity(10);
        product.setMinQuantity(5);
        product.setMaxQuantity(30);
        product.setProviderID("ProviderId1");

        Mockito.when(iProductRepository.findAll()).thenReturn(Flux.just(product));
        Flux<ProductDTO> productDTOFlux = getAllProductsUseCase.getProducts();

        StepVerifier.create(productDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(iProductRepository).findAll();
    }


}