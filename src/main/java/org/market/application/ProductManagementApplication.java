package org.market.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.market.products",
			"org.market.controllers", "org.market.Repositories",
			"org.market.services", "org.market.exeption", "org.market.dtos"})
@EntityScan(basePackages = "org.market.products")
@EnableJpaRepositories(basePackages = "org.market.Repositories")
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
