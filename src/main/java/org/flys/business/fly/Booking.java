package org.flys.business.fly;

import org.flys.business.Identifier;
import org.flys.business.persons.Passenger;

import java.util.HashSet;
import java.util.UUID;

public class Booking implements Identifier {
    protected final UUID idBooking= UUID.randomUUID();
    protected HashSet<Seat> reservedSeats = new HashSet<>();
    protected Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public HashSet<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(HashSet<Seat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    @Override
    public UUID getId() {
        return idBooking;
    }
}
