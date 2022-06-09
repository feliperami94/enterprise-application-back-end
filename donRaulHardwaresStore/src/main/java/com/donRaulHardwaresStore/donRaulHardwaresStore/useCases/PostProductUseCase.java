package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostProductUseCase {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public PostProductUseCase(IProductRepository iProductRepository, ProductMapper productMapper){
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper ;
    }

    public Mono<ProductDTO> postProduct(ProductDTO productDTO){
        return iProductRepository.save(productMapper.productDTOToProduct(productDTO)).map(productMapper::productToProductDTO);
    }
}
