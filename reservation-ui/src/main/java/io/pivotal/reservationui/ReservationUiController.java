package io.pivotal.reservationui;

import java.util.ArrayList;
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

		Collection<Reservation> res = new ArrayList<>();

		/*Reservation reservation1 = new Reservation();
		Reservation reservation2 = new Reservation();
		
		reservation1.setId(1L);
		reservation1.setName("Mayuresh");
		reservation1.setStatus("confirmed");
		res.add(reservation1);

		reservation2.setId(2L);
		reservation2.setName("Clint");
		reservation2.setStatus("pending");
		res.add(reservation2);*/

		res = reservationService.getAllReservation();
		return res;
	}
	@PostMapping("/reservations")
	public void saveReservation() {
		
	}

	}
