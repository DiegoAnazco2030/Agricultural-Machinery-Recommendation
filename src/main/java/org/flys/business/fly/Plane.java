package org.flys.business.fly;

import org.flys.business.Identifier;

import java.util.HashSet;
import java.util.UUID;

public class Plane implements Identifier {
    private final UUID idPlane= UUID.randomUUID();
    private final HashSet<Seat> flightSeats = new HashSet<>();
    private AircraftModel model;
    private int cantSeats;

    public Plane(AircraftModel model, int cantSeats) {
        this.model = model;
        this.cantSeats = cantSeats;
        for (int i = 0; i < getNumSeats(); i++) {
            if (i < getNumSeats() * 0.1) {
                flightSeats.add(new Seat(false, SeatType.FIRST_CLASS));
            } else if (i < getNumSeats() * 0.3) {
                flightSeats.add(new Seat(false, SeatType.BUSINESS_CLASS));
            } else
            flightSeats.add(new Seat(false, SeatType.ECONOMY_CLASS));
        }
    }

    // Retorna el Set de asientos del avión
    public HashSet<Seat> getFlightSeats() {
        return flightSeats;
    }
    // Añade un asiento al Set de asientos del avión
    public void setFlightSeats(Seat flightSeats) {
        this.flightSeats.add(flightSeats);
    }

    public int getNumSeats(){
        return switch (this.model) {
            case BOEING_737 -> 160;
            case AIRBUS_A320 -> 150;
            case BOEING_787 -> 100;
            case AIRBUS_A350 -> 70;
        };
    }

    public AircraftModel getModel() {
        return model;
    }

    public void setModel(AircraftModel model) {
        this.model = model;
    }

    public int getCantSeats() {
        return cantSeats;
    }

    public void setCantSeats(int cantSeats) {
        this.cantSeats = cantSeats;
    }

    @Override
    public UUID getId() {
        return idPlane;
    }
}
