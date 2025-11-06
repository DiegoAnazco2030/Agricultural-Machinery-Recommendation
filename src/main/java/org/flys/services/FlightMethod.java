package org.flys.services;

import org.flys.business.fly.Plane;
import org.flys.services.DTOs.FlyCreateDTO;
import org.flys.services.DTOs.FlyUpdateDTO;
import org.flys.services.DTOs.FlyResponseDTO;

import java.util.List;
import java.util.Optional;

public interface FlightMethod {

    FlyResponseDTO createFly(FlyCreateDTO dto);

    Optional<FlyResponseDTO> getFly(String id);

    List<FlyResponseDTO> listFlys();

    List<Plane> listPlanes();

    Optional<FlyResponseDTO> updateFly(FlyUpdateDTO dto);

    boolean deleteFly(String id);
}