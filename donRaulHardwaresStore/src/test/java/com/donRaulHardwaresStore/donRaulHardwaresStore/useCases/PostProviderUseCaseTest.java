package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostProviderUseCaseTest {

    @MockBean
    PostProviderUseCase postProviderUseCase;

    @Test
    void postProviderUseCaseTest(){
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setProviderId("12345");
        providerDTO.setProviderName("Juan");
        providerDTO.setProviderPhone("311382");
        providerDTO.setProviderPassport("ABCD1234");
        providerDTO.setAvailability(true);

        StepVerifier.create(Mono.just(Mockito.when(postProviderUseCase.postProvider(providerDTO))
                .thenReturn(Mono.just(providerDTO))))
                .expectNextCount(1)
                .expectComplete()
                .verify();

    }

}