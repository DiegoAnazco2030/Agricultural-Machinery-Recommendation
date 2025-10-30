package org.flys.services.DTOs;

import java.time.LocalDateTime;

public class FlyResponseDTO {
    public final String id;
    public final String origin;
    public final String destination;
    public final LocalDateTime departure;
    public final String planeId;

    public FlyResponseDTO(String id, String origin, String destination, LocalDateTime departure, String planeId) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.planeId = planeId;
    }
}
