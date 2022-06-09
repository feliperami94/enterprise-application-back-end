package com.donRaulHardwaresStore.donRaulHardwaresStore.useCases;

import com.donRaulHardwaresStore.donRaulHardwaresStore.dtos.ProviderDTO;
import com.donRaulHardwaresStore.donRaulHardwaresStore.mappers.ProviderMapper;
import com.donRaulHardwaresStore.donRaulHardwaresStore.repositories.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PutProviderUseCase {
    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public PutProviderUseCase(IProviderRepository iProviderRepository, ProviderMapper providerMapper){
        this.iProviderRepository = iProviderRepository;
        this.providerMapper = providerMapper;
    }

    public Mono<ProviderDTO> putProvider(ProviderDTO providerDTO){
        return iProviderRepository.save(providerMapper.providerDTOToProvider(providerDTO)).map(providerMapper::providerToProviderDTO);
    }
}
