package org.flys.services.DTOs;

/**
 * String departureDateTime debe tener el siguiente formato:
 * "yyyy-MM-dd HH:mm"
 */
public record FlyUpdateDTO(String id, String origin, String destination) {
    // Constructor de 4 argumentos
}
