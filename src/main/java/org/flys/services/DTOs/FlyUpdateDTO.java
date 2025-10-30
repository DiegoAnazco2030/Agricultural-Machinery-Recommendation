package org.flys.services.DTOs;

import java.time.LocalDateTime;

public class FlyUpdateDTO {
    public final String origin;
    public final String destination;
    public final LocalDateTime departure;

    public FlyUpdateDTO(String origin, String destination, LocalDateTime departure) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
    }
}
