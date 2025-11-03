package org.flys.presentation;

import org.flys.services.DTOs.*;

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

    public static PassengerCreateDTO getPassengerCreateDTO() {
        System.out.println("Ingrese los detalles del nuevo pasajero:");
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
        System.out.println("Ingrese los detalles a modificar del pasajero:");
        String id = MenuObjects.getString("ID del pasajero a modificar:");
        String name = MenuObjects.getString("Nuevo Nombre (deje en blanco para no cambiar):");
        String surname = MenuObjects.getString("Nuevo Apellido (deje en blanco para no cambiar):");
        String email = MenuObjects.getString("Nuevo Email (deje en blanco para no cambiar):");
        String phone = MenuObjects.getString("Nuevo Teléfono (deje en blanco para no cambiar):");
        String passport = MenuObjects.getString("Nuevo Pasaporte (deje en blanco para no cambiar):");

        // No pedimos edad para simplificar, pero se podría
        return new PassengerUpdateDTO(id,
                name.isBlank() ? null : name,
                surname.isBlank() ? null : surname,
                email.isBlank() ? null : email,
                phone.isBlank() ? null : phone,
                -1, // No actualizamos edad
                passport.isBlank() ? null : passport
        );
    }

    public static BookingCreateDTO getBookingCreateDTO() {
        System.out.println("Ingrese los detalles de la nueva reserva:");
        String passengerId = MenuObjects.getString("ID del Pasajero:");
        String flightId = MenuObjects.getString("ID del Vuelo:");
        return new BookingCreateDTO(passengerId, flightId);
    }
}
