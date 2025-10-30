package org.flys.business.persons;

import org.flys.business.Identifier;

import java.util.UUID;

public class Passenger extends Person implements Identifier {



    public UUID getId() {
        return getPersonID();
    }
}
