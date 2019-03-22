package io.pivotal.reactive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;


    @Test
    public void getEventsTest()
    {

        String reservationId = this.reservationService
                .findAll()
                .blockFirst()
                .getId();

        StepVerifier.withVirtualTime(() -> this.reservationService.getEvents(reservationId)
                .take(10)
                .collectList())
                .thenAwait(Duration.ofSeconds(20))
                .consumeNextWith(list -> Assert.assertTrue(list.size() == 10))
                .verifyComplete();
    }
}
