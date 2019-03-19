package io.pivotal.reservationui;

import java.util.ArrayList;
import java.util.Collection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Slf4j
@EnableConfigurationProperties(ReservationConfig.class)
public class ReservationService {

	@Autowired
	private ReservationConfig reservationConfig;

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackReservation")
	public Collection<Reservation> getAllReservation() {

//		ResponseEntity<Collection<Reservation>> response = restTemplate.exchange(
//				"https://belk-reservation-service.cfapps.io/reservations/", HttpMethod.GET, null,
//
//
//				new ParameterizedTypeReference<Collection<Reservation>>() {
//				});

		ResponseEntity<Collection<Reservation>> response = restTemplate.exchange(
				"https://BELK-RESERVATION-SERVICE/reservations/", HttpMethod.GET, null,
				new ParameterizedTypeReference<Collection<Reservation>>() {
				});
		
		return response.getBody();
	}

	private Collection<Reservation> fallbackReservation() {

		ArrayList<Reservation> res = new ArrayList<>();
		Reservation reservation = new Reservation();
		reservation.setId(1L);
		reservation.setName(reservationConfig.getFallbackName());
		reservation.setStatus("pending");
		res.add(reservation);

		return res;
	}

}
