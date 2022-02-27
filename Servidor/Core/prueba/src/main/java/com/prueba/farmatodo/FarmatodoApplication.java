package com.prueba.farmatodo;

import com.prueba.farmatodo.dto.LocalizacionDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages= {"com.prueba.farmatodo", "com.prueba.farmatodo.repository"})
@EntityScan(basePackages= {"com.prueba.farmatodo.entity"})
public class FarmatodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmatodoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){ return new RestTemplate(); }

	@Bean LocalizacionDto localizacionDto(){ return new LocalizacionDto(); }
}


