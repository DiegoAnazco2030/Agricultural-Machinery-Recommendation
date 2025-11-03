package org.flys.presentation.controllers;

import org.flys.presentation.InputHandler;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.services.ReservationService;
import org.flys.services.DTOs.BookingResponseDTO;

import java.util.List;

public class ReservationController {

    public void reservationControllerInit(ReservationService service) {
        boolean returnToMain = false;
        while (!returnToMain) {
            Menu.reservationManagementMenu();
            int option = MenuObjects.getInt(1, 5);

            try {
                switch (option) {
                    case 1: // Crear
                        createReservation(service);
                        break;
                    case 2: // Modificar (Pendiente)
                        System.out.println("ℹModificar reservas aún no está implementado.");
                        break;
                    case 3: // Cancelar
                        cancelReservation(service);
                        break;
                    case 4: // Ver
                        viewReservations(service);
                        break;
                    case 5: // Retornar
                        returnToMain = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }
        }
    }

    private void createReservation(ReservationService service) {
        var dto = InputHandler.getBookingCreateDTO();
        BookingResponseDTO response = service.createBooking(dto);
        System.out.println("Reserva creada con éxito.");
        System.out.println("ID: " + response.bookingId());
        System.out.println("Pasajero: " + response.passengerName());
        System.out.println("Vuelo: " + response.flightInfo());
    }

    private void viewReservations(ReservationService service) {
        List<BookingResponseDTO> bookings = service.listAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("ℹNo hay reservas registradas.");
            return;
        }

        System.out.println("--- Lista de Reservas ---");
        for (BookingResponseDTO dto : bookings) {
            System.out.printf("ID: %s | Pasajero: %s | Vuelo: %s\n",
                    dto.bookingId(),
                    dto.passengerName(),
                    dto.flightInfo()
            );
        }
    }

    private void cancelReservation(ReservationService service) {
        String id = MenuObjects.getString("Ingrese el ID de la reserva a cancelar:");
        if (service.cancelBooking(id)) {
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("Error: No se pudo encontrar la reserva con ese ID.");
        }
    }
}