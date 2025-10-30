package org.flys.business.fly;

import org.flys.business.Identifier;

import java.util.Objects;
import java.util.UUID;

public abstract class Seat implements Identifier {
    protected final UUID idSeat= UUID.randomUUID();
    protected boolean useState;
    protected SeatType seatType;

    public Seat(boolean useState, SeatType seatType) {
        this.useState = true;
        this.seatType= Objects.requireNonNull(seatType);

    }

    public boolean isUseStage() {
        return useState;
    }

    public void setUseStage(boolean useStage) {
        this.useState = useStage;
    }

    @Override
    public UUID getId() {
        return idSeat;
    }
}
