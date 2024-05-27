package com.tecomerce.appproductcategory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
		@Server(url = "https://mic-productcategory-production.up.railway.app/")
})
public class MicProductCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicProductCategoryApplication.class, args);
	}

}
