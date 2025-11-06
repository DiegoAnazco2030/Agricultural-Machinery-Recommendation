package org.flys.services.DTOs;

public record PassengerUpdateDTO(
        String id,
        String email,
        String phoneNumber
) {
}