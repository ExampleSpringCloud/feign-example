package com.marcuschiu.feignexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignExampleApplication {

	@Autowired
	BookServiceClient bookServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignExampleApplication.class, args);
	}

	@GetMapping("/get-books")
	public String greeting() {
		return bookServiceClient.getBooks();
	}

	@GetMapping("/get-book-service-instance")
	public String getInstanceServiceInfo() {
		return bookServiceClient.getLocalServiceInstance();
	}
}
