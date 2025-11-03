package org.flys.services.DTOs;

// Para mostrar una reserva, damos un resumen
public record BookingResponseDTO(
        String bookingId,
        String passengerName,
        String flightInfo // Ej. "Quito -> Lima"
) {
}