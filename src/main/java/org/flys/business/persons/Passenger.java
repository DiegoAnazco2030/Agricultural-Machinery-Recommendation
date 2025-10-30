package org.flys.business.persons;

import org.flys.business.Identifier;

import java.util.UUID;

public class Passenger extends Person implements Identifier {

    public Passenger(String name, String surname, int age, String email, String phoneNumber) {
        super(name, surname, age, email, phoneNumber);
    }

    @Override
    public UUID getId() {
        return getPersonID();
    }
}
