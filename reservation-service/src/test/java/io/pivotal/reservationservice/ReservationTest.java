package io.pivotal.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ReservationTest {

    @Test
    public void ReservationTest()
    {
        Reservation res = new Reservation(1L, "John Doe", "booked");
        Assertions.assertThat(res).isNotNull();
    }
}
