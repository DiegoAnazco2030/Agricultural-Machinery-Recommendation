package org.flys.business.persons;

public class Passenger extends Person{

    private String passport;

    public Passenger(String name, String surname, int age, String email, String phoneNumber, String passport) {
        super(name, surname, age, email, phoneNumber);
        this.passport = passport;
    }

    public Passenger(){
        super();
        this.passport = "000";
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
