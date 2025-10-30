package org.flys.business.fly;

import org.flys.business.Identifier;
import org.flys.business.SeatType;

import java.util.Objects;
import java.util.UUID;

public class Seat implements Identifier {
    protected final UUID idSeat= UUID.randomUUID();
    protected boolean useStage;
    protected SeatType seatType;

    public Seat(boolean useStage, SeatType seatType) {
        this.useStage = true;
        this.seatType= Objects.requireNonNull(seatType);

    }

    public boolean isUseStage() {
        return useStage;
    }

    public void setUseStage(boolean useStage) {
        this.useStage = useStage;
    }

    @Override
    public UUID getId() {
        return idSeat;
    }
}
