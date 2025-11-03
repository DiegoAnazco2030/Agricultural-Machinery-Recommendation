package org.flys;

import org.flys.business.Flight;
import org.flys.business.fly.AircraftModel;
import org.flys.business.fly.Booking;
import org.flys.business.fly.Plane;
import org.flys.business.persons.Passenger;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.presentation.controllers.FlightController;
import org.flys.presentation.controllers.PassengerController;
import org.flys.presentation.controllers.ReservationController;
import org.flys.repository.InMemoryRepository;
import org.flys.services.FlysServices;
import org.flys.services.PassengerService;
import org.flys.services.ReservationService;

public class Main {

    // 5. ¡Corrección Importante!
    // El método main de Java debe tener esta firma exacta para ejecutarse.
    public static void main(String[] args) {
        boolean exit = false;

        // --- Configuración de Repositorios ---
        // Creamos un repositorio en memoria para CADA entidad
        InMemoryRepository<Flight> flightRepo = new InMemoryRepository<>();
        InMemoryRepository<Plane> planeRepo = new InMemoryRepository<>();
        InMemoryRepository<Passenger> passengerRepo = new InMemoryRepository<>();
        InMemoryRepository<Booking> bookingRepo = new InMemoryRepository<>();

        // --- Configuración de Servicios ---
        // Inyectamos los repositorios que cada servicio necesita
        FlysServices flysServices = new FlysServices(flightRepo, planeRepo);
        PassengerService passengerService = new PassengerService(passengerRepo);
        ReservationService reservationService = new ReservationService(bookingRepo, passengerRepo, flightRepo);

        // --- Configuración de Controladores ---
        FlightController flightController = new FlightController();
        PassengerController passengerController = new PassengerController();
        ReservationController reservationController = new ReservationController();


        // --- Datos de Prueba ---
        // Creamos un avión de prueba para que se puedan crear vuelos
        Plane plane1 = new Plane(AircraftModel.AIRBUS_A320, 180);
        planeRepo.save(plane1);
        System.out.println("¡Bienvenido al Sistema de Vuelos!");
        System.out.println("Avión de prueba (Airbus A320) creado con ID: " + plane1.getId().toString());


        do {
            Menu.mainMenu();
            int option = MenuObjects.getInt(1, 4);

            switch (option) {
                case 1:
                    // Ahora la lógica está encapsulada en el controlador
                    flightController.flightControllerInit(flysServices);
                    break;
                case 2:
                    // Llamamos al nuevo controlador de reservas
                    reservationController.reservationControllerInit(reservationService);
                    break;
                case 3:
                    // Llamamos al nuevo controlador de pasajeros
                    passengerController.passengerControllerInit(passengerService);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
            }

            // Esto es para "limpiar" la consola, pero no funciona en todos
            // los IDEs. Es mejor solo imprimir espacios.
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            if (!exit) {
                System.out.println("\n--- Presione Enter para continuar ---");
                MenuObjects.getString(); // Espera que el usuario presione Enter
            }

        } while (!exit);

        MenuObjects.close(); // Cerramos el scanner al salir
    }
}