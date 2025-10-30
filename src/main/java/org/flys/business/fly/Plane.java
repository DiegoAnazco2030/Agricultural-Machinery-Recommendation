package org.flys.business.fly;

import org.flys.business.Identifier;

import java.util.UUID;

public class Plane implements Identifier {
    protected final UUID idPlane= UUID.randomUUID();;
    protected AircraftModel model;
    protected int cantSeats;

    public Plane(AircraftModel model, int cantSeats) {
        this.model = model;
        this.cantSeats = cantSeats;
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
