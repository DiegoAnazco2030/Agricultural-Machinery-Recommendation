package org.flys.services.DTOs;

public record PassengerResponseDTO(
        String id,
        String fullName,
        String email,
        String passport
) {
}