package org.flys.services; // O la ubicación que prefieras para las interfaces

import org.flys.services.DTOs.BookingCreateDTO;
import org.flys.services.DTOs.BookingResponseDTO;

import java.util.List;

// Define el contrato para el servicio de reservas
public interface ReservationMethod {

    // Método para crear una reserva
    BookingResponseDTO createBooking(BookingCreateDTO dto);

    // Método para cancelar una reserva
    boolean cancelBooking(String bookingId);

    // Método para listar todas las reservas
    List<BookingResponseDTO> listAllBookings();
}