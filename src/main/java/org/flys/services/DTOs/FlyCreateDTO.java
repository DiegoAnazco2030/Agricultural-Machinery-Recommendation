package org.flys.services.DTOs;

/**
 * String departureDateTime debe tener el siguiente formato:
 * "yyyy-MM-dd HH:mm"
 */
public record FlyCreateDTO(String origin, String destination, String planeId) {
    // Constructor de 4 argumentos
}
