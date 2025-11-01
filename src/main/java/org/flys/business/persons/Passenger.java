package org.flys.business.persons;

public class Passenger extends Person{
    private String passport;

    public Passenger(String name, String surname, String email, String phoneNumber, int age, String passport) {
        super(name, surname, email, phoneNumber, age);
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
