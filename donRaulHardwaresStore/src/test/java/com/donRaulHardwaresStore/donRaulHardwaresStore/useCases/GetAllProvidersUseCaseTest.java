package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
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
class GetAllProvidersUseCaseTest {

    @Mock
    IProviderRepository iProviderRepository;

    @Autowired
    private ProviderMapper providerMapper;

    private GetAllProvidersUseCase getAllProvidersUseCase;

    @BeforeEach
    void beforeEach(){
        getAllProvidersUseCase = new GetAllProvidersUseCase(iProviderRepository, providerMapper);
    }

    @Test
    void getAllProvidersTest(){
        Provider provider = new Provider();
        provider.setProviderId("ProviderId1");
        provider.setProviderName("ProviderName1");
        provider.setProviderPhone("1234567");
        provider.setProviderPassport("ABC123");
        provider.setAvailability(true);

        Provider provider2 = new Provider();
        provider2.setProviderId("ProviderId2");
        provider2.setProviderName("ProviderName2");
        provider2.setProviderPhone("23455678");
        provider.setProviderPassport("DEF456");
        provider.setAvailability(true);

        Mockito.when(iProviderRepository.findAll()).thenReturn(Flux.just(provider, provider2));
        Flux<ProviderDTO> providerDTOFlux = getAllProvidersUseCase.getProviders();

        StepVerifier.create(providerDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(iProviderRepository).findAll();


    }




}