package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "provider")
public class Provider {
    @Id
    private String providerId;
    private String providerName;
    private Integer providerPhone;
    private String providerEmail;
}
