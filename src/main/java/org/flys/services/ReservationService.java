package org.flys.services;

import org.flys.business.Flight;
import org.flys.business.fly.Booking;
import org.flys.business.persons.Passenger;
import org.flys.repository.Repository;
import org.flys.services.DTOs.BookingCreateDTO;
import org.flys.services.DTOs.BookingResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReservationService implements ReservationMethod{

    // 4. ¡Múltiples Dependencias!
    // Este servicio necesita hablar con 3 repositorios
    // para poder conectar las entidades.
    private final Repository<Booking> bookingRepository;
    private final Repository<Passenger> passengerRepository;
    private final Repository<Flight> flightRepository;

    public ReservationService(Repository<Booking> bookingRepository,
                              Repository<Passenger> passengerRepository,
                              Repository<Flight> flightRepository) {
        this.bookingRepository = bookingRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public BookingResponseDTO createBooking(BookingCreateDTO dto) {
        // 1. Encontrar al pasajero
        Passenger passenger = passengerRepository.findById(UUID.fromString(dto.passengerId()))
                .orElseThrow(() -> new IllegalArgumentException("Pasajero no encontrado"));

        // 2. Encontrar el vuelo
        Flight flight = flightRepository.findById(UUID.fromString(dto.flightId()))
                .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));

        // 3. Crear la reserva
        Booking newBooking = new Booking();
        newBooking.setPassenger(passenger);
        // Aquí iría la lógica de asignar asientos, que es compleja.
        // Por ahora, la reserva se crea.

        // 4. Guardar la reserva
        Booking savedBooking = bookingRepository.save(newBooking);

        // 5. ¡Importante! Añadimos la reserva al vuelo
        flight.setBookings(savedBooking);
        flightRepository.update(flight); // Actualizamos el vuelo

        return mapToDTO(savedBooking);
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        try {
            UUID uuid = UUID.fromString(bookingId);
            Optional<Booking> maybeBooking = bookingRepository.findById(uuid);

            if (maybeBooking.isEmpty()) {
                return false;
            }

            // Lógica adicional:
            // 1. Encontrar el vuelo asociado a esta reserva
            // 2. Quitar la reserva de la lista de 'bookings' del vuelo
            // 3. Liberar los asientos asociados

            // Por ahora, solo eliminamos la reserva principal:
            bookingRepository.deleteById(uuid);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    // Listar todas las reservas (simple)
    public List<BookingResponseDTO> listAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    private BookingResponseDTO mapToDTO(Booking booking) {
        // Buscamos el vuelo que CONTIENE esta reserva
        // Esto es ineficiente, pero funciona para empezar
        Optional<Flight> flight = flightRepository.findAll().stream()
                .filter(f -> f.getBookings().contains(booking))
                .findFirst();

        String flightInfo = "Vuelo no asignado";
        if(flight.isPresent()) {
            flightInfo = String.format("%s (%s -> %s)",
                    flight.get().getId().toString(),
                    flight.get().getFlightDestination().getDeparture(),
                    flight.get().getFlightDestination().getArrival()
            );
        }

        return new BookingResponseDTO(
                booking.getId().toString(),
                booking.getPassenger().getName() + " " + booking.getPassenger().getSurname(),
                flightInfo
        );
    }
}