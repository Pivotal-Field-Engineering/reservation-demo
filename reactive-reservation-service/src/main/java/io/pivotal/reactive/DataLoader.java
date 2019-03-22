package io.pivotal.reactive;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    private final ReservationRepository reservationRepository;

    public DataLoader(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostConstruct
    public  void loadData() {

        Flux<Reservation> reservations = Flux.just(
                new Reservation("Tokyo", "booked"),
                new Reservation("Paris", "booked"),
                new Reservation("Milan", "booked"));

        this.reservationRepository.saveAll(reservations).subscribe(System.out::println);


        System.out.println("\nAll records in DB:\n");
        this.reservationRepository
                .findAll()
                .subscribe(movie -> System.out.println("> Found in DB: " + movie));
    }
}
