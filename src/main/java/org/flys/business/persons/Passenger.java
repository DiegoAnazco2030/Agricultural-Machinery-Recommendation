package org.flys.business.persons;

import org.flys.business.Identifier;

public class Passenger extends Person implements Identifier {



    public UUID getId() {
        return getPersonID();
    }
}
