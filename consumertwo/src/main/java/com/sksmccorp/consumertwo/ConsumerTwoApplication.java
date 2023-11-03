package com.sksmccorp.consumertwo;

import com.sksmccorp.consumertwo.service.ConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerTwoApplication.class, args);
		ConsumerService consumerService = new ConsumerService();
		consumerService.consume();
	}

}
