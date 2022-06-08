package com.donRaulHardwaresStore.donRaulHardwaresStore.repositories;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
