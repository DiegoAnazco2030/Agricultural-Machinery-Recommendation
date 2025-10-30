package org.flys.business;


import org.flys.business.fly.*;
import org.flys.business.persons.Employee;

import java.util.HashSet;
import java.util.UUID;

public class Fligth implements Identifier {
    protected final UUID idFlight= UUID.randomUUID();
    protected HashSet<Booking> bookings = new HashSet<>();
    protected Plane flightPlane;
    protected Destination flightDestination;
    protected HashSet<Employee> flightCrew = new HashSet<>();
    protected HashSet<Seat> flightSeats = new HashSet<>();

    public Fligth(HashSet<Booking> bookings, HashSet<Employee> flightCrew, Destination flightDestination, Plane flightPlane, HashSet<Seat> flightSeats) {
        this.bookings = bookings;
        this.flightCrew = flightCrew;
        this.flightDestination = flightDestination;
        this.flightPlane = flightPlane;
        this.flightSeats = flightSeats;
    }

    @Override
    public UUID getId() {
        return idFlight;
    }

}

