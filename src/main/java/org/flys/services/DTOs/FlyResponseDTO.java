package org.flys.services.DTOs;

// ELIMINAR: import java.time.LocalDateTime;

public class FlyResponseDTO {
    public final String id;
    public final String origin;
    public final String destination;
    // ELIMINADO: public final LocalDateTime departure;
    public final String planeId;

    // Constructor de 4 argumentos
    public FlyResponseDTO(String id, String origin, String destination, String planeId) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.planeId = planeId;
    }
}