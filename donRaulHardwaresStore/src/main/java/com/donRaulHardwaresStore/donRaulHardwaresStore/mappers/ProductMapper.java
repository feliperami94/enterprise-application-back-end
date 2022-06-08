package com.donRaulHardwaresStore.donRaulHardwaresStore.mappers;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Bill;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.BillDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper productMapper;


    public ProductMapper(ModelMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductDTO productToProductDTO(Product product){return productMapper.map(product, ProductDTO.class);}
    public Product productDTOToProduct(ProductDTO productDTO){return productMapper.map(productDTO, Product.class);}
}
