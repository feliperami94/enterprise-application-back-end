package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProductMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProvidersUseCase {
    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public GetAllProvidersUseCase(IProviderRepository iProviderRepository, ProviderMapper providerMapper){
        this.iProviderRepository = iProviderRepository;
        this.providerMapper = providerMapper;
    }

    public Flux<ProviderDTO> getProviders(){
        return iProviderRepository.findAll().map(providerMapper::providerToProviderDTO);
    }
}
