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
    private void loadData() {
        this.reservationRepository.deleteAll().thenMany(
                Flux.just("Paris",
                        "Tokyo",
                        "Milan")
                        .map(Reservation::new)
                        .flatMap(this.reservationRepository::save))
                .subscribe(System.out::println);

//        System.out.println("\nAll records in DB:\n");
//        this.movieRepository
//                .findAll()
//                .subscribe(movie -> System.out.println("> Found in DB: " + movie.toString()));
    }
}
