package com.shoe_ecommerce.shopping_cart;

import org.springframework.boot.SpringApplication;

public class TestCartApplication {

	public static void main(String[] args) {
		SpringApplication.from(ShoppingCartApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
