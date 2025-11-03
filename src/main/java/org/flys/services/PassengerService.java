package org.flys.services;

import org.flys.business.persons.Passenger;
import org.flys.repository.Repository;
import org.flys.services.DTOs.PassengerCreateDTO;
import org.flys.services.DTOs.PassengerResponseDTO;
import org.flys.services.DTOs.PassengerUpdateDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class PassengerService {

    private final Repository<Passenger> passengerRepository;

    // 1. Inyección de Dependencias (¡Buena práctica!)
    // Le pasamos el repositorio que necesita para funcionar.
    public PassengerService(Repository<Passenger> passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    // Método para crear un pasajero
    public PassengerResponseDTO createPassenger(PassengerCreateDTO dto) {
        // Aquí irían validaciones (ej. email no nulo, edad > 0)
        if (dto.name() == null || dto.name().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (dto.passport() == null || dto.passport().isBlank()) {
            throw new IllegalArgumentException("El pasaporte es obligatorio");
        }

        Passenger passenger = new Passenger(
                dto.name(),
                dto.surname(),
                dto.email(),
                dto.phoneNumber(),
                dto.age(),
                dto.passport()
        );

        Passenger savedPassenger = passengerRepository.save(passenger);
        return mapToDTO(savedPassenger);
    }

    // Método para obtener un pasajero por su ID
    public Optional<PassengerResponseDTO> getPassengerById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return passengerRepository.findById(uuid).map(this::mapToDTO);
        } catch (IllegalArgumentException e) {
            // Si el ID no es un UUID válido, retornamos vacío
            return Optional.empty();
        }
    }

    // Método para listar todos los pasajeros
    public List<PassengerResponseDTO> listPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(this::mapToDTO) // Usamos el helper 'mapToDTO'
                .collect(Collectors.toList());
    }

    // Método para eliminar un pasajero
    public boolean deletePassenger(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            if (passengerRepository.findById(uuid).isPresent()) {
                passengerRepository.deleteById(uuid);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Método para actualizar un pasajero
    public Optional<PassengerResponseDTO> updatePassenger(PassengerUpdateDTO dto) {
        try {
            UUID uuid = UUID.fromString(dto.id());
            Optional<Passenger> maybePassenger = passengerRepository.findById(uuid);

            if (maybePassenger.isEmpty()) {
                return Optional.empty(); // No se encontró el pasajero
            }

            Passenger passenger = maybePassenger.get();

            // Actualizamos solo los campos que vienen en el DTO
            if (dto.name() != null) passenger.setName(dto.name());
            if (dto.surname() != null) passenger.setSurname(dto.surname());
            if (dto.email() != null) passenger.setEmail(dto.email());
            if (dto.phoneNumber() != null) passenger.setPhoneNumber(dto.phoneNumber());
            if (dto.age() > 0) passenger.setAge(dto.age());
            if (dto.passport() != null) passenger.setPassport(dto.passport());

            Passenger updatedPassenger = passengerRepository.update(passenger);
            return Optional.of(mapToDTO(updatedPassenger));

        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }


    // 2. Helper (Ayudante)
    // Un método privado para convertir la entidad (Passenger) al DTO (PassengerResponseDTO)
    private PassengerResponseDTO mapToDTO(Passenger passenger) {
        return new PassengerResponseDTO(
                passenger.getId().toString(),
                passenger.getName() + " " + passenger.getSurname(),
                passenger.getEmail(),
                passenger.getPassport()
        );
    }
}