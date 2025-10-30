package org.flys.business.fly;

public class Destination {
    private Countries Departure ;
    private Countries Arrival;

    public Destination(Countries arrival, Countries departure) {
        Arrival = arrival;
        Departure = departure;
    }

    public Countries getArrival() {
        return Arrival;
    }

    public void setArrival(Countries arrival) {
        Arrival = arrival;
    }

    public Countries getDeparture() {
        return Departure;
    }

    public void setDeparture(Countries departure) {
        Departure = departure;
    }
}
