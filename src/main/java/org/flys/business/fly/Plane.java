package org.flys.business.fly;

import org.flys.business.Identifier;

import java.util.HashSet;
import java.util.UUID;

public class Plane implements Identifier {
    protected final UUID idPlane= UUID.randomUUID();;
    protected AircraftModel model;
    protected int cantSeats;
    protected HashSet<Seat> flightSeats = new HashSet<>();

    public Plane(AircraftModel model, int cantSeats, HashSet<Seat> flightSeats) {
        this.model = model;
        this.cantSeats = cantSeats;
        this.flightSeats = flightSeats;
    }

    public int getNumSeats(){
        return switch (this.model) {
            case AIRBUS_A320 -> 150;
            case BOEING_737 -> 160;
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
