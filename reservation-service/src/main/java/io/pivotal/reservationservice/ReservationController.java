package io.pivotal.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id)
    {
        return reservationService.findReservationById(id);
    }

    @GetMapping
    public Collection<Reservation> getAllReservations()
    {
        return reservationService.findAll();
    }

    @PostMapping
    public Collection<Reservation> saveReservations(@RequestBody Collection<Reservation> coll)
    {
        return reservationService.saveAll(coll);
    }


}
