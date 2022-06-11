package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PutProductUseCase {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public PutProductUseCase(IProductRepository iProductRepository, ProductMapper productMapper){
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper;
    }

    public Mono<ProductDTO> putProduct(ProductDTO productDTO){
        return iProductRepository.save(productMapper.productDTOToProduct(productDTO)).map(productMapper::productToProductDTO);
    }
}
