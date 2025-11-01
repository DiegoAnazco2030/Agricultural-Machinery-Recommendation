package org.flys.presentation.controllers;

import org.flys.presentation.InputHandler;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.services.DTOs.FlyResponseDTO;
import org.flys.services.FlysServices;

import java.util.Optional;

public class FlightController {
    public Optional<Optional<FlyResponseDTO>> flightControllerInit(FlysServices service) {
        Menu.flightManagementMenu();

        switch (MenuObjects.getInt(1, 4)) {
            case 1:
                return Optional.of(Optional.ofNullable(service.createFly(InputHandler.getFlyCreateDTO())));
            case 2:
                return Optional.ofNullable(service.updateFly(InputHandler.getFlyUpdateDTO()));
            case 3:
                return null;
            case 4:
                viewFlights(service);
                return null;
        }
        return null;
    }

    private void viewFlights(FlysServices service) {
        for (FlyResponseDTO dto : service.listFlys()) {
            System.out.printf("%s | From: %s | To: %s | Departure: %s | Plane ID: %s\n",
                    dto.id(),
                    dto.origin(),
                    dto.destination(),
                    dto.departureDateTime(),
                    dto.planeId());
        }
    }
}
