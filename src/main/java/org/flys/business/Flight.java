package org.flys.business;

import org.flys.business.fly.*;
import org.flys.business.persons.Employee;

import java.util.HashSet;
import java.util.UUID;

public class Flight implements Identifier {
    private final UUID idFlight = UUID.randomUUID();
    private final HashSet<Booking> bookings = new HashSet<>();
    private final HashSet<Employee> flightCrew = new HashSet<>();
    private Plane flightPlane;
    private Destination flightDestination;

    public Flight(Plane flightPlane, Destination flightDestination) {
        this.flightPlane = flightPlane;
        this.flightDestination = flightDestination;
    }

    @Override
    public UUID getId() {
        return idFlight;
    }

    // Retorna el Set de reservas del vuelo
    public HashSet<Booking> getBookings() {
        return bookings;
    }
    // Añade una reserva al Set de reservas del vuelo
    public void setBookings(Booking booking) {
        this.bookings.add(booking);
    }

    // Retorna el Set de emplados del vuelo
    public HashSet<Employee> getFlightCrew() {
        return flightCrew;
    }
    // Añade un empleado al Set de empleados del vuelo
    public void setFlightCrew(Employee flightCrew) {
        this.flightCrew.add(flightCrew);
    }

    public Destination getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(Destination flightDestination) {
        this.flightDestination = flightDestination;
    }

    public Plane getFlightPlane() {
        return flightPlane;
    }

    public void setFlightPlane(Plane flightPlane) {
        this.flightPlane = flightPlane;
    }

    public UUID getIdFlight() {
        return idFlight;
    }
}
