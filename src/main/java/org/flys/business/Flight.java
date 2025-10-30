package org.flys.business;


import org.flys.business.fly.*;
import org.flys.business.persons.Employee;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

public class Flight implements Identifier {
    private final UUID idFlight= UUID.randomUUID();
    private HashSet<Booking> bookings = new HashSet<>();
    private Plane flightPlane;
    private Destination flightDestination;
    private HashSet<Employee> flightCrew = new HashSet<>();

    private LocalDateTime departureDateTime;
    public Flight(HashSet<Booking> bookings, HashSet<Employee> flightCrew, Destination flightDestination, Plane flightPlane, HashSet<Seat> flightSeats) {
        this.bookings = bookings;
        this.flightCrew = flightCrew;
        this.flightDestination = flightDestination;
        this.flightPlane = flightPlane;
    }

    @Override
    public UUID getId() {
        return idFlight;
    }

    public HashSet<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(HashSet<Booking> bookings) {
        this.bookings = bookings;
    }

    public HashSet<Employee> getFlightCrew() {
        return flightCrew;
    }

    public void setFlightCrew(HashSet<Employee> flightCrew) {
        this.flightCrew = flightCrew;
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
