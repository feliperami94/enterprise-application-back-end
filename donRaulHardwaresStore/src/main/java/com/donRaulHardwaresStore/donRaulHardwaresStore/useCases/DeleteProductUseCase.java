package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public DeleteProductUseCase(IProductRepository iProductRepository, ProductMapper productMapper){
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper;
    }

    public Mono<Void> deleteProductID(String id){
        return iProductRepository.deleteById(id);
    }

}
