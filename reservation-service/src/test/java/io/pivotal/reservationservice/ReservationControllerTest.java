package io.pivotal.reservationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@WebMvcTest(secure = false)
@RunWith(SpringRunner.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getReservationTest() throws Exception
    {
        Mockito.when(reservationService.findAll()).thenReturn(Collections.singletonList(new Reservation(null, "John Doe", "booked")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getReservationByIdTest() throws Exception
    {
        Long id = 1L;
        Mockito.when(reservationService.findReservationById(id)).thenReturn(new Reservation(1L, "John Doe", "booked"));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations/1")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void saveReservationTest() throws Exception {

        Reservation res = new Reservation(null, "John Doe", "booked");

        List<Reservation> col = Collections.singletonList(res);

        Mockito.when(this.reservationService.saveAll(col)).thenReturn(col);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/reservations").content(mapper.writeValueAsString(col)).contentType("application/json").characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

