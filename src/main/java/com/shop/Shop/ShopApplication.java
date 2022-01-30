package com.shop.Shop;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleData(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customers(1, "denis", "King Street", "morozov@hot.ee", 21));
		};
	}

}
