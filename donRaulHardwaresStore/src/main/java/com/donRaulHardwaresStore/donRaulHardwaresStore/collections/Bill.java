package com.donRaulHardwaresStore.donRaulHardwaresStore.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    private LocalDate date;



}
