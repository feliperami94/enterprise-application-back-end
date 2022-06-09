package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;


import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsUseCase {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public GetAllProductsUseCase(IProductRepository iProductRepository, ProductMapper productMapper){
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper;
    }

    public Flux<ProductDTO> getProducts(){
        return iProductRepository.findAll().map(productMapper::productToProductDTO);
    }
}
