package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProductDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostProviderUseCase {
    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public PostProviderUseCase(IProviderRepository iProviderRepository, ProviderMapper providerMapper){
        this.iProviderRepository = iProviderRepository;
        this.providerMapper = providerMapper;
    }

    public Mono<ProviderDTO> postProvider(ProviderDTO providerDTO){
        return iProviderRepository.save(providerMapper.providerDTOToProvider(providerDTO)).map(providerMapper::providerToProviderDTO);
    }

}
