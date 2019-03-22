package io.pivotal.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    public Collection<Reservation> findAll() {

        return reservationRepository.findAll();
    }


    public Collection<Reservation> saveAll(Collection<Reservation> coll) {

        return reservationRepository.saveAll(coll);
    }

    public Reservation findReservationById(Long id) {

        return reservationRepository.findById(id).get();
    }
}
