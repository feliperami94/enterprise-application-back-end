package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.GetAllProvidersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProvidersRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllProviders(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(GET("/v1/api/all-providers"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProvidersUseCase.getProviders(), ProviderDTO.class)));
    }
}
