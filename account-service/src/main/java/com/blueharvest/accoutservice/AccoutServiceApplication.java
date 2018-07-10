package com.blueharvest.accoutservice;

import com.blueharvest.accoutservice.client.TransactionClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = { TransactionClient.class })
public class AccoutServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccoutServiceApplication.class, args);
	}
}
