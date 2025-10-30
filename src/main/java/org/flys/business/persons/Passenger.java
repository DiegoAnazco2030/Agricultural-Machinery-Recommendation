package org.flys.business.persons;

public class Passenger extends Person{

    String passport;

    public Passenger(String name, String surname, int age, String email, String phoneNumber) {
        super(name, surname, age, email, phoneNumber);
    }


}
