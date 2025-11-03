package org.flys.presentation;

public class Menu {
    // Menu principal
    public static void mainMenu() {
        System.out.println("-------------------Main Menu-------------------");
        System.out.println("1.- Flight Management");
        System.out.println("2.- Reservation Management");
        System.out.println("3.- Passenger Management");
        System.out.println("4.- Exit");
    }

    // Menu de gestión de vuelos
    public static void flightManagementMenu() {
        System.out.println("----------------Flight Management----------------");
        System.out.println("1.- Register new flight");
        System.out.println("2.- Modify existing flight");
        System.out.println("3.- Delete flight");
        System.out.println("4.- View flights");
        System.out.println("5.- Return");
    }

    // Menu de gestión de reservas
    public static void reservationManagementMenu() {
        System.out.println("--------------Reservation Management-------------");
        System.out.println("1.- Create new reservation");
        System.out.println("2.- Modify reservation");
        System.out.println("3.- Cancel reservation");
        System.out.println("4.- View reservations");
        System.out.println("5.- Return");
    }

    // Menu de gestión de pasajeros
    public static void passengerManagementMenu() {
        System.out.println("---------------Passenger Management---------------");
        System.out.println("1.- Register new passenger");
        System.out.println("2.- Modify passenger data");
        System.out.println("3.- Delete passenger");
        System.out.println("4.- View passengers");
        System.out.println("5.- Return");
    }
}
