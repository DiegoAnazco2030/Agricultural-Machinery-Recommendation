package org.flys.services; // O la ubicación que prefieras para las interfaces

import org.flys.services.DTOs.PassengerCreateDTO;
import org.flys.services.DTOs.PassengerResponseDTO;
import org.flys.services.DTOs.PassengerUpdateDTO;

import java.util.List;
import java.util.Optional;

// Define el contrato para el servicio de pasajeros
public interface PassengerMethod {

    // Método para crear un pasajero
    PassengerResponseDTO createPassenger(PassengerCreateDTO dto);

    // Método para obtener un pasajero por su ID
    Optional<PassengerResponseDTO> getPassengerById(String id);

    // Método para listar todos los pasajeros
    List<PassengerResponseDTO> listPassengers();

    // Método para eliminar un pasajero
    boolean deletePassenger(String id);

    // Método para actualizar un pasajero
    Optional<PassengerResponseDTO> updatePassenger(PassengerUpdateDTO dto);
}