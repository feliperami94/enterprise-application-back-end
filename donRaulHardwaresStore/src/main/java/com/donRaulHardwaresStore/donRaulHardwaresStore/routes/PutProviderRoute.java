package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostProviderUseCase;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PutProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> putProvider(PutProviderUseCase putProviderUseCase){
        return route(PUT("/v1/api/putProvider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(putProviderUseCase::putProvider)
                        .flatMap(providerDTO -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDTO)));

    }
}
