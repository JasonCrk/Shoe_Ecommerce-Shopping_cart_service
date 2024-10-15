package com.shoe_ecommerce.shopping_cart;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
		value = { "com.shoe_ecommerce.shopping_cart" }
)
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
