package com.ec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ec.mapper")

public class EcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcAppApplication.class, args);
	}

}
