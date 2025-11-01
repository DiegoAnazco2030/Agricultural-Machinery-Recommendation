package org.flys.services;

import org.flys.services.DTOs.FlyCreateDTO;
import org.flys.services.DTOs.FlyUpdateDTO;
import org.flys.services.DTOs.FlyResponseDTO;

import java.util.List;
import java.util.Optional;

public interface FlightMethods {

    FlyResponseDTO createFly(FlyCreateDTO dto);

    Optional<FlyResponseDTO> getFly(String id);

    List<FlyResponseDTO> listFlys();

    Optional<FlyResponseDTO> updateFly(FlyUpdateDTO dto);

    boolean deleteFly(String id);
}