package org.flys.services.DTOs;

public record PassengerCreateDTO(
        String name,
        String surname,
        String email,
        String phoneNumber,
        int age,
        String passport
) {
}