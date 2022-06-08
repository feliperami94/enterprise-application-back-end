package com.donRaulHardwaresStore.donRaulHardwaresStore.repositories;

import com.donRaulHardwaresStore.donRaulHardwaresStore.collections.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
