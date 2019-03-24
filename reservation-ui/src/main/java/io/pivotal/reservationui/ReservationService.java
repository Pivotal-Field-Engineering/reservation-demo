package io.pivotal.reservationui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;


@Service
@Slf4j
public class ReservationService {


	@Autowired
	private RestTemplate restTemplate;

	public Collection<Reservation> getAllReservation() {

		ResponseEntity<Collection<Reservation>> response = restTemplate.exchange(
				"http://localhost:8080/reservations", HttpMethod.GET, null,

				new ParameterizedTypeReference<Collection<Reservation>>() {
				});
		
		return response.getBody();
	}


}
