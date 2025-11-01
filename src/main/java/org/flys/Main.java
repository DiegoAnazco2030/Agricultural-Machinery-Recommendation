package org.flys;

import org.flys.business.Flight;
import org.flys.business.fly.AircraftModel;
import org.flys.business.fly.Plane;
import org.flys.presentation.Menu;
import org.flys.presentation.MenuObjects;
import org.flys.presentation.controllers.FlightController;
import org.flys.repository.InMemoryRepository;
import org.flys.services.FlysServices;

public class Main {
    static void main() {
        boolean exit = false;
        int option;
        InMemoryRepository<Flight> flightRepo = new InMemoryRepository<>();
        InMemoryRepository<Plane> planeRepo = new InMemoryRepository<>();
        FlysServices service = new FlysServices(flightRepo, planeRepo);
        FlightController flightController = new FlightController();

        Plane plane1 = new Plane(AircraftModel.AIRBUS_A320, 180);
        planeRepo.save(plane1);
        System.out.println(plane1.getId().toString() + "\n");

        do {
            Menu.mainMenu();

            switch (MenuObjects.getInt(1, 4)) {
                case 1:
                    flightController.flightControllerInit(service);
                    break;
                case 2:
                    // Lógica para gestión de reservas

                    break;
                case 3:
                    // Lógica para gestión de pasajeros

                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } while (!exit);
    }
}
