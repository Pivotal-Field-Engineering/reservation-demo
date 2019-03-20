package io.pivotal.reservationui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class ReservationUiApplication {

	   	@Bean
	    public RestTemplate restTemplate() {
	      return new RestTemplate();
	    }
		public static void main(String[] args) {
		SpringApplication.run(ReservationUiApplication.class, args);
	}
}
