package org.flys.presentation;

import org.flys.services.DTOs.FlyCreateDTO;
import org.flys.services.DTOs.FlyUpdateDTO;

public class InputHandler {
    public static FlyCreateDTO getFlyCreateDTO() {
        System.out.println("Ingrese los detalles del vuelo:");

        String origin = MenuObjects.getString("Ingrese el origen: ");
        String destination = MenuObjects.getString("Ingrese el destino: ");
        String planeId = MenuObjects.getString("Ingrese el ID del avión: ");
        String departureDateTime = MenuObjects.getString("Ingrese la fecha y hora de salida (yyyy-MM-dd HH:mm): ");

        return new FlyCreateDTO(origin, destination, planeId, departureDateTime);
    }

    public static FlyUpdateDTO getFlyUpdateDTO() {
        System.out.println("Ingrese los detalles actualizados del vuelo:");

        String id = MenuObjects.getString("Ingrese el ID del vuelo a modificar: ");
        String origin = MenuObjects.getString("Ingrese el origen: ");
        String destination = MenuObjects.getString("Ingrese el destino: ");
        String departureDateTime = MenuObjects.getString("Ingrese la fecha y hora de salida (yyyy-MM-dd HH:mm): ");

        return new FlyUpdateDTO(id, origin, destination, departureDateTime);
    }
}
