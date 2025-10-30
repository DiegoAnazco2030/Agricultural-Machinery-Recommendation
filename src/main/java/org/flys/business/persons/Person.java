package org.flys.business.persons;

import org.flys.business.Identifier;

import java.util.UUID;

public abstract class Person implements Identifier {

    private final java.util.UUID personID = java.util.UUID.randomUUID();
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;

    public Person(String name, String surname, int age, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person(){
        this.name = "Jonh";
        this.surname = "Doe";
        this.age = 18;
        this.email = "reserva@u.com";
        this.phoneNumber = "999";
    }

    @Override
    public UUID getId() {
        return getPersonID();
    }

    public UUID getPersonID() {
        return personID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
