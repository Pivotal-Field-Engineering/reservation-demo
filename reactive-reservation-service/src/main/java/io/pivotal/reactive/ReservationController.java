package io.pivotal.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/{id}")
    public Mono<Reservation> getReservation(@PathVariable String id)
    {
        return reservationService.findReservationById(id);
    }


    @GetMapping
    public Flux<Reservation> getAllReservations()
    {
        return reservationService.findAll();
    }

    @PostMapping
    public Flux<Reservation> saveReservations(@RequestBody Collection<Reservation> coll)
    {
        return reservationService.saveAll(coll);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ReservationEvent> getEvents(@PathVariable final String id)
    {
        return reservationService.getEvents(id);

    }
}
