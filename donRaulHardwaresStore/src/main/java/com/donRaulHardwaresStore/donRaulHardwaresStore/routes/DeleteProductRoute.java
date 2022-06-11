package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.DeleteProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProductUseCase){
        return route(DELETE("/v1/api/deleteProduct/{productId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProductUseCase.deleteProductID(request.pathVariable("productId"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
