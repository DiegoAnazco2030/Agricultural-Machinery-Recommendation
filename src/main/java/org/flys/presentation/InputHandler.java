package org.flys.presentation;

import org.flys.services.DTOs.*;

public class InputHandler {
    public static FlyCreateDTO getFlyCreateDTO() {
        String origin = MenuObjects.getString("Ingrese el origen: ");
        String destination = MenuObjects.getString("Ingrese el destino: ");
        String planeId = MenuObjects.getString("Ingrese el ID del avión: ");

        return new FlyCreateDTO(origin, destination, planeId);
    }

    public static FlyUpdateDTO getFlyUpdateDTO() {
        String id = MenuObjects.getString("Ingrese el ID del vuelo a modificar: ");
        String origin = MenuObjects.getString("Ingrese el origen: ");
        String destination = MenuObjects.getString("Ingrese el destino: ");

        return new FlyUpdateDTO(id, origin, destination);
    }

    public static PassengerCreateDTO getPassengerCreateDTO() {
        String name = MenuObjects.getString("Nombre:");
        String surname = MenuObjects.getString("Apellido:");
        String email = MenuObjects.getString("Email:");
        String phone = MenuObjects.getString("Teléfono:");
        System.out.println("Edad:");
        int age = MenuObjects.getInt();
        String passport = MenuObjects.getString("Pasaporte:");
        return new PassengerCreateDTO(name, surname, email, phone, age, passport);
    }

    public static PassengerUpdateDTO getPassengerUpdateDTO() {
        String id = MenuObjects.getString("ID del pasajero a modificar:");
        String email = MenuObjects.getString("Nuevo Email (deje en blanco para no cambiar):");
        String phone = MenuObjects.getString("Nuevo Teléfono (deje en blanco para no cambiar):");

        // No pedimos edad para simplificar, pero se podría
        return new PassengerUpdateDTO(id, email, phone);
    }

    public static BookingCreateDTO getBookingCreateDTO() {
        String passengerId = MenuObjects.getString("ID del Pasajero:");
        String flightId = MenuObjects.getString("ID del Vuelo:");
        return new BookingCreateDTO(passengerId, flightId);
    }
}
