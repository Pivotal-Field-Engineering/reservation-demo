package io.pivotal.reservationui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@EnableCircuitBreaker
@EnableDiscoveryClient
public class ReservationUiApplication {

	   	@Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	      return new RestTemplate();
	    }
	public static void main(String[] args) {
		SpringApplication.run(ReservationUiApplication.class, args);
	}
}
