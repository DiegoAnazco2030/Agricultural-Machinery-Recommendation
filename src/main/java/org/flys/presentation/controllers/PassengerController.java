package org.flys.presentation.controllers;

import org.flys.presentation.InputHandler;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.services.PassengerService;
import org.flys.services.DTOs.PassengerResponseDTO;

import java.util.List;
import java.util.Optional;

public class PassengerController {

    // Este método orquesta el menú de pasajeros
    public void passengerControllerInit(PassengerService service) {
        boolean returnToMain = false;
        while (!returnToMain) {
            Menu.passengerManagementMenu();
            int option = MenuObjects.getInt(1, 5);

            // 3. ¡Importante! Usamos 'try-catch'
            // Esto evita que la app 'crashee' si el usuario ingresa
            // datos malos (ej. un email inválido) que el 'Service' rechace.
            try {
                switch (option) {
                    case 1: // Registrar
                        registerPassenger(service);
                        break;
                    case 2: // Modificar
                        modifyPassenger(service);
                        break;
                    case 3: // Eliminar
                        deletePassenger(service);
                        break;
                    case 4: // Ver
                        viewPassengers(service);
                        break;
                    case 5: // Retornar
                        returnToMain = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                // Capturamos errores de validación del 'Service'
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // Capturamos cualquier otro error inesperado
                System.out.println("Ocurrió un error inesperado.");
                e.printStackTrace(); // Esto ayuda a depurar
            }
        }
    }

    private void registerPassenger(PassengerService service) {
        // Usamos el 'InputHandler' para pedir los datos
        var dto = InputHandler.getPassengerCreateDTO();
        PassengerResponseDTO response = service.createPassenger(dto);
        System.out.println("Pasajero creado con éxito. ID: " + response.id());
    }

    private void viewPassengers(PassengerService service) {
        List<PassengerResponseDTO> passengers = service.listPassengers();
        if (passengers.isEmpty()) {
            System.out.println("No hay pasajeros registrados.");
            return;
        }

        System.out.println("--- Lista de Pasajeros ---");
        for (PassengerResponseDTO dto : passengers) {
            System.out.printf("ID: %s | Nombre: %s | Email: %s | Pasaporte: %s\n",
                    dto.id(),
                    dto.fullName(),
                    dto.email(),
                    dto.passport()
            );
        }
    }

    private void modifyPassenger(PassengerService service) {
        var dto = InputHandler.getPassengerUpdateDTO();
        Optional<PassengerResponseDTO> response = service.updatePassenger(dto);

        if(response.isPresent()) {
            System.out.println("Pasajero actualizado con éxito.");
        } else {
            System.out.println("Error: No se pudo encontrar el pasajero con ese ID.");
        }
    }

    private void deletePassenger(PassengerService service) {
        String id = MenuObjects.getString("Ingrese el ID del pasajero a eliminar:");
        if (service.deletePassenger(id)) {
            System.out.println("Pasajero eliminado con éxito.");
        } else {
            System.out.println("Error: No se pudo encontrar el pasajero con ese ID.");
        }
    }
}