package org.flys.business.fly;

import org.flys.business.Identifier;
import org.flys.business.persons.Passenger;

import java.util.HashSet;
import java.util.UUID;

public class Booking implements Identifier {
    private final UUID idBooking= UUID.randomUUID();
    private final HashSet<Seat> reservedSeats = new HashSet<>();
    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Retorna el Set de asientos reservados en la reserva
    public HashSet<Seat> getReservedSeats() {
        return reservedSeats;
    }
    // Añade un asiento al Set de asientos reservados en la reserva
    public void setReservedSeats(Seat reservedSeats) {
        this.reservedSeats.add(reservedSeats);
    }

    @Override
    public UUID getId() {
        return idBooking;
    }
}
