package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.GetAllReceiptsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class GetAllReceiptsRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllReceipts(GetAllReceiptsUseCase getAllReceiptsUseCase){
        return route(GET("/v1/api/allReceipts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllReceiptsUseCase.getReceipts(), ReceiptDTO.class)));
    }
}
