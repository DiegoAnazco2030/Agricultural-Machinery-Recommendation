package org.flys.presentation;

public class Menu {
    public static void flightManagementMenu() {
        System.out.println("----------------Gestion de vuelos----------------");
        System.out.println("1.- Register new flight");
        System.out.println("2.- Modificar vuelo existente");
        System.out.println("3.- Eliminar vuelo");
        System.out.println("4.- Consultar vuelos");
    }

    public static void reservationManagementMenu() {
        System.out.println("---------------Gestion de reservas---------------");
        System.out.println("1.- Crear nueva reserva");
        System.out.println("2.- Modificar reserva");
        System.out.println("3.- Cancelar reserva");
        System.out.println("4.- Consultar reservas");
    }

    public static void passengerManagementMenu() {
        System.out.println("---------------Gestion de pasajeros---------------");
        System.out.println("1.- Registrar nuevo pasajero");
        System.out.println("2-. Modificar datos del pasajero");
        System.out.println("3.- Eliminar pasajero");
        System.out.println("4.- Consultar pasajeros");
    }
}
