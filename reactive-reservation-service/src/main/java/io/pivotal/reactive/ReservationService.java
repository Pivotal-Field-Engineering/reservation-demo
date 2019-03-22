package io.pivotal.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collection;
import java.util.Date;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    public Flux<Reservation> findAll() {

        return reservationRepository.findAll();
    }


    public Flux<Reservation> saveAll(Collection<Reservation> coll) {

        return reservationRepository.saveAll(coll);
    }

    public Mono<Reservation> findReservationById(String id) {

        return reservationRepository.findById(id);
    }

    public Flux<ReservationEvent> getEvents(String id) {

        return Flux.<ReservationEvent>generate(
                sink -> sink.next(new ReservationEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1));
    }
}