package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostProductUseCase;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostProviderUseCase;
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
public class PostProductRoute {
    @Bean
    public RouterFunction<ServerResponse> postProduct(PostProductUseCase postProductUseCase){
        return route(POST("/v1/api/postProduct").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(postProductUseCase::postProduct)
                        .flatMap(productDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDTO)));

    }
}
