package org.flys.services.DTOs;

// ELIMINAR: import java.time.LocalDateTime;

public class FlyCreateDTO {
    public final String origin;
    public final String destination;
    // ELIMINADO: public final LocalDateTime departure;
    public final String planeId;

    // Constructor de 3 argumentos
    public FlyCreateDTO(String origin, String destination, String planeId) {
        this.origin = origin;
        this.destination = destination;
        this.planeId = planeId;
    }
}