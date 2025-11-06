package org.flys.presentation.controllers;

import org.flys.business.fly.Plane;
import org.flys.presentation.InputHandler;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.services.DTOs.FlyResponseDTO;
import org.flys.services.FlysServices;

import java.util.Optional;

public class FlightController {
    public void flightControllerInit(FlysServices service) {
        boolean returnToMain = false;
        while (!returnToMain) {
            Menu.flightManagementMenu();

            try {
                switch (MenuObjects.getInt(1, 5)) {
                    case 1: // Crear
                        viewPlanes(service);
                        FlyResponseDTO responseCreate = service.createFly(InputHandler.getFlyCreateDTO());
                        System.out.println("Vuelo creado con éxito. ID: " + responseCreate.id());
                        break;
                    case 2: // Modificar
                        viewIdFlights(service);
                        Optional<FlyResponseDTO> responseUpdata = service.updateFly(InputHandler.getFlyUpdateDTO());
                        if (responseUpdata.isEmpty()) {
                            System.out.println("No se encontró un vuelo con el ID proporcionado.");
                        } else {
                            System.out.println("Vuelo modificado con éxito. ID: " + responseUpdata.get().id());
                        }
                        break;
                    case 3: // Cancelar
                        viewIdFlights(service);
                        deleteFlight(service);
                        break;
                    case 4: // Ver
                        viewFlights(service);
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

    private void deleteFlight(FlysServices service) {
        String id = MenuObjects.getString("Ingrese el ID del vuelo a cancelar: ");
        if (service.deleteFly(id)) {
            System.out.println("Vuelo cancelado con éxito.");
        } else {
            System.out.println("No se encontró un vuelo con el ID proporcionado.");
        }
    }

    private void viewFlights(FlysServices service) {
        if (service.listFlys().isEmpty()) {
            System.out.println("No hay vuelos disponibles.");
            return;
        }

        for (FlyResponseDTO dto : service.listFlys()) {
            System.out.printf("%s | From: %s | To: %s | Plane ID: %s\n",
                    dto.id(),
                    dto.origin(),
                    dto.destination(),
                    dto.planeId());
        }
    }

    private void viewIdFlights(FlysServices service) {
        for (FlyResponseDTO dto : service.listFlys()) {
            System.out.printf("%s | From: %s | To: %s\n",
                    dto.id(),
                    dto.origin(),
                    dto.destination());
        }
    }

    private void viewPlanes(FlysServices service) {
        System.out.println("Lista de Aviones Disponibles:");
        for (Plane plane : service.listPlanes()) {
            System.out.printf("ID: %s | Modelo: %s\n",
                    plane.getId(),
                    plane.getModel());
        }
    }
}
