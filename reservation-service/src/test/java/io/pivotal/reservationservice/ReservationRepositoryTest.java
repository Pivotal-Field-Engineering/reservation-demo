package io.pivotal.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    ReservationRepository reservationRepository;

    @Before
    public void setup()
    {
        em.persist(new Reservation(null, "First last", "booked"));
    }


    @Test
    public void mappingTest() {

        Reservation res = em.persistFlushFind(new Reservation(null, "John Doe", "booked"));
        Assertions.assertThat(res.getId()).isNotZero().isGreaterThan(0);

    }

    @Test
    public void findTest() {

        Assertions.assertThat(reservationRepository.findAll().size()).isGreaterThan(0);

    }
}
