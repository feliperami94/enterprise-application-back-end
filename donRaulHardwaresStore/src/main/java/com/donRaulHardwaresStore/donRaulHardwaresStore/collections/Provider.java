package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "provider")
public class Provider {
    @Id
    private String providerId = UUID.randomUUID().toString();
    private String providerName;
    private String providerPhone;
    private String providerEmail;
}
