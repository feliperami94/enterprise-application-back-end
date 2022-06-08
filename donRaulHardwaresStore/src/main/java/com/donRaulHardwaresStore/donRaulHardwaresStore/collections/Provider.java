package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "provider")
@Data
public class Provider {
    @Id
    private String providerId;
    private String providerName;
    private String providerPhone;
    private String providerEmail;
}
