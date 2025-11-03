package org.flys.services.DTOs;

public record PassengerUpdateDTO(
        String id,
        String name,
        String surname,
        String email,
        String phoneNumber,
        int age,
        String passport
) {
}