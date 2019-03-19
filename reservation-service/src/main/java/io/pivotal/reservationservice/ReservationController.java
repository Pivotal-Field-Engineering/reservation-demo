package io.pivotal.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository repo;

    @GetMapping("/reservations")
    public Collection<Reservation> getAllReservations()
    {
        return repo.findAll();
    }

    @PostMapping("/reservations")
    public Collection<Reservation> saveReservations(@RequestBody Collection<Reservation> coll)
    {
        return repo.saveAll(coll);
    }


}
