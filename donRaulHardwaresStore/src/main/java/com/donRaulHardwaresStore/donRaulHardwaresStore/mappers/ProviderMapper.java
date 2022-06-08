package com.donRaulHardwaresStore.donRaulHardwaresStore.mappers;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    private final ModelMapper providerMapper;


    public ProviderMapper(ModelMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    public ProviderDTO providerToProviderDTO(Provider provider){return providerMapper.map(provider, ProviderDTO.class);}
    public Provider providerDTOToProvider(ProviderDTO providerDTO){return providerMapper.map(providerDTO, Provider.class);}
}
