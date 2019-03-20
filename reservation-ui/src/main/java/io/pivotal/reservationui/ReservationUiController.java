package io.pivotal.reservationui;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationUiController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservations")
	public Collection<Reservation> allReservations() {


		Collection<Reservation> res = reservationService.getAllReservation();
		return res;
	}
	@PostMapping("/reservations")
	public void saveReservation() {
		
	}

}
