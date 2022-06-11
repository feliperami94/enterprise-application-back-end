package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ReceiptDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostBillUseCase;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostBillRoute {
    @Bean
    public RouterFunction<ServerResponse> postBill(PostBillUseCase postBillUseCase){
        return route(POST("/v1/api/postBill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class)
                        .flatMap(postBillUseCase::postBill)
                        .flatMap(billDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(billDTO)));

    }

}
