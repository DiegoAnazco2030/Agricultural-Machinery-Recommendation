package org.flys.services.DTOs;

import java.time.LocalDateTime;

public class FlyCreateDTO {
    public final String origin;
    public final String destination;
    public final LocalDateTime departure;
    public final String planeId; // ajustar tipo si usa Identifier u otro

    public FlyCreateDTO(String origin, String destination, LocalDateTime departure, String planeId) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.planeId = planeId;
    }
}
