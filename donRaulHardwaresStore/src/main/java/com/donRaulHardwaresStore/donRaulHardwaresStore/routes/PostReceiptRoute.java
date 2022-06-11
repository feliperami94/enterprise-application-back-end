package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;


import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostProviderUseCase;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class PostReceiptRoute {
    @Bean
    public RouterFunction<ServerResponse> postReceipt(PostReceiptUseCase postReceiptUseCase){
        return route(POST("/v1/api/postReceipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(postReceiptUseCase::postReceipt)
                        .flatMap(receiptDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptDTO)));

    }
}
