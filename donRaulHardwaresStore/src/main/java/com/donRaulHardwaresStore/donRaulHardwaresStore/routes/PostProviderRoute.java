package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.PostProviderUseCase;
import com.mongodb.internal.connection.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> postProvider(PostProviderUseCase postProviderUseCase){
        return route(POST("/v1/api/postProvider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(postProviderUseCase::postProvider)
                        .flatMap(providerDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDTO)));

    }
}
