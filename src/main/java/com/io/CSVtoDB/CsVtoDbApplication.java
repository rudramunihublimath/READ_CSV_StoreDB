package com.io.CSVtoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CsVtoDbApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CsVtoDbApplication.class, args);
		ProductService productService=context.getBean(ProductService.class);
		String csvFile = "product.csv";


		productService.read(csvFile);

		productService.findall();

	}

}
