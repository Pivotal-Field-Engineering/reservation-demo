package io.pivotal.reactive;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String status;
}
