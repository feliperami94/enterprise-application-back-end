package com.donRaulHardwaresStore.donRaulHardwaresStore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Don Raul's Hardware Store", version = "1.0", description = "Documentation APIs v1.0"))
public class DonRaulHardwaresStoreApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DonRaulHardwaresStoreApplication.class, args);
	}



}
