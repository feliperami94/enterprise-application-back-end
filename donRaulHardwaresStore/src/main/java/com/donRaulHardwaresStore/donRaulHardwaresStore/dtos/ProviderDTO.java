package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ProviderDTO {
    private String providerId = UUID.randomUUID().toString();
    private String providerName;
    private String providerPhone;
    private String providerEmail;
}
