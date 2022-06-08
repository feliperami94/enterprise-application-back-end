package com.donRaulHardwaresStore.donRaulHardwaresStore.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ProviderDTO {
    private String providerId;
    private String providerName;
    private String providerPhone;
    private String providerEmail;
}
