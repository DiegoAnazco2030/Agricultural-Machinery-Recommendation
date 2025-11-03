package org.flys.services.DTOs;

// Para crear una reserva, necesitamos saber QUÉ pasajero y a QUÉ vuelo.
public record BookingCreateDTO(
        String passengerId,
        String flightId
        // Nota: La gestión de asientos específicos es mucho más compleja.
        // Por ahora, solo creamos la reserva.
) {
}