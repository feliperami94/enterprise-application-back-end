package com.donRaulHardwaresStore.donRaulHardwaresStore.routes;


import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.GetAllProductsUseCase;
import com.donRaulHardwaresStore.donRaulHardwaresStore.useCases.GetAllProvidersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {
    @Bean
    @RouterOperation(path = "/v1/api/allProducts", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET, beanClass = GetAllProductsUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "getAllProducts", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = Product.class)))}
            ))

    public RouterFunction<ServerResponse> getAllProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("/v1/api/allProducts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductsUseCase.getProducts(), ProductDTO.class)));
    }
}
