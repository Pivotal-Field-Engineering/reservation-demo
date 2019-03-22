package io.pivotal.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {


}
