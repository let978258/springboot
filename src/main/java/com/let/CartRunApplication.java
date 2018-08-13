package com.let;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.let.mapper")
public class CartRunApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CartRunApplication.class, args);
	}

}
