package com.donRaulHardwaresStore.donRaulHardwaresStore.repositories;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends ReactiveMongoRepository<Provider, String> {
}
