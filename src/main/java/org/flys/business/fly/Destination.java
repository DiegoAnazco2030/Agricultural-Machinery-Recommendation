package org.flys.business.fly;

public abstract class Destination {
    protected Countries Departure ;
    protected Countries Arrival;

    public Destination(Countries arrival, Countries departure) {
        Arrival = arrival;
        Departure = departure;
    }
}
