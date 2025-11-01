package org.flys.business.fly;

import org.flys.business.Identifier;

import java.util.Objects;
import java.util.UUID;

public class Seat implements Identifier {
    private final UUID idSeat = UUID.randomUUID();
    private boolean useState;
    private SeatType seatType;

    public Seat(boolean useState, SeatType seatType) {
        this.useState = useState;
        this.seatType= Objects.requireNonNull(seatType, "seatType es obligatorio");
    }

    public Seat(SeatType seatType) {
        this.useState = false;
        this.seatType= Objects.requireNonNull(seatType, "seatType es obligatorio");
    }

    public boolean isUseStage() {
        return useState;
    }

    public void setUseStage(boolean useStage) {
        this.useState = useStage;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public UUID getId() {
        return idSeat;
    }
}
