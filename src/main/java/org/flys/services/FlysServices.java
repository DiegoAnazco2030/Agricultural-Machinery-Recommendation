package org.flys.services;

import org.flys.business.Flight;
import org.flys.business.fly.Countries;
import org.flys.business.fly.Destination;
import org.flys.business.fly.Plane;
import org.flys.repository.Repository;
import org.flys.services.DTOs.FlyCreateDTO;
import org.flys.services.DTOs.FlyUpdateDTO;
import org.flys.services.DTOs.FlyResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class FlysServices implements FlightMethods {

    private final Repository<Flight> flightRepository;
    private final Repository<Plane> planeRepository;

    public FlysServices(Repository<Flight> flightRepository, Repository<Plane> planeRepository) {
        this.flightRepository = flightRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public FlyResponseDTO createFly(FlyCreateDTO dto) {
        if (dto.origin == null || dto.origin.isBlank()) throw new IllegalArgumentException("origin required");
        if (dto.destination == null || dto.destination.isBlank()) throw new IllegalArgumentException("destination required");

        try {
            Countries departureCountry = Countries.valueOf(dto.origin.toUpperCase());
            Countries arrivalCountry = Countries.valueOf(dto.destination.toUpperCase());
            Destination flightDest = new Destination(departureCountry, arrivalCountry);

            UUID planeUUID = UUID.fromString(dto.planeId);
            Plane plane = planeRepository.findById(planeUUID)
                    .orElseThrow(() -> new IllegalArgumentException("Plane with ID " + dto.planeId + " not found."));

            Flight newFlight = new Flight(flightDest, plane, dto.departure);

            Flight savedFlight = flightRepository.save(newFlight);
            return mapToDTO(savedFlight);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid data: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<FlyResponseDTO> getFly(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Optional<Flight> maybe = flightRepository.findById(uuid);
            return maybe.map(this::mapToDTO);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<FlyResponseDTO> listFlys() {
        List<Flight> all = flightRepository.findAll();
        return all.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<FlyResponseDTO> updateFly(String id, FlyUpdateDTO dto) {
        try {
            UUID uuid = UUID.fromString(id);
            Optional<Flight> maybe = flightRepository.findById(uuid);
            if (maybe.isEmpty()) return Optional.empty();

            Flight fly = maybe.get();

            if (dto.origin != null && !dto.origin.isBlank()){
                Countries newDeparture = Countries.valueOf(dto.origin.toUpperCase());
                fly.getFlightDestination().setDeparture(newDeparture);
            }
            if (dto.destination != null && !dto.destination.isBlank()){
                Countries newArrival = Countries.valueOf(dto.destination.toUpperCase());
                fly.getFlightDestination().setArrival(newArrival);
            }
            if (dto.departure != null) {
                fly.setDepartureDateTime(dto.departure);
            }

            Flight updatedFly = flightRepository.save(fly);

            return Optional.of(mapToDTO(updatedFly));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteFly(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            boolean existed = flightRepository.findById(uuid).isPresent();
            if (existed) {
                flightRepository.deleteById(uuid);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private FlyResponseDTO mapToDTO(Flight fly) {
        return new FlyResponseDTO(
                fly.getId().toString(),
                fly.getFlightDestination().getDeparture().name(),
                fly.getFlightDestination().getArrival().name(),
                fly.getDepartureDateTime(),
                fly.getFlightPlane().getId().toString()
        );
    }
}