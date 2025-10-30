package org.flys.services;

import org.flys.business.Fligth;
import org.flys.repository.Repository;
import org.flys.services.DTOs.FlyCreateDTO;
import org.flys.services.DTOs.FlyUpdateDTO;
import org.flys.services.DTOs.FlyResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


public class FlysServices {

    private final Repository repository;

    public FlysServices(Repository repository) {
        this.repository = repository;
    }

    // Crear vuelo
    public FlyResponseDTO createFly(FlyCreateDTO dto) {
        // validaciones básicas
        if (dto.origin == null || dto.origin.isBlank()) throw new IllegalArgumentException("origin required");
        if (dto.destination == null || dto.destination.isBlank()) throw new IllegalArgumentException("destination required");
        // mapear DTO -> entidad (ajusta constructor/propiedades de Fly)
        Fligth fly = new Fligth(/* pasar campos adecuados, ej: dto.origin, dto.destination, dto.departure, dto.planeId */);
        // persistir: ajustar el método save según tu Repository
        repository.save(fly); // TODO: verificar firma real
        return mapToDTO(fly);
    }

    // Obtener por id
    public Optional<FlyResponseDTO> getFly(String id) {
        // ajustar findById según Repository
        Optional<Fligth> maybe = repository.findById(id); // TODO: adaptar
        return maybe.map(this::mapToDTO);
    }

    // Listar todos
    public List<FlyResponseDTO> listFlys() {
        List<Fligth> all = repository.findAll(); // TODO: adaptar
        return all.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Actualizar
    public Optional<FlyResponseDTO> updateFly(String id, FlyUpdateDTO dto) {
        Optional<Fligth> maybe = repository.findById(id); // TODO: adaptar
        if (maybe.isEmpty()) return Optional.empty();
        Fligth fly = maybe.get();
        // aplicar cambios (ajusta setters o usa builder/inmutabilidad)
        if (dto.origin != null && !dto.origin.isBlank()) fly.setOrigin(dto.origin);
        if (dto.destination != null && !dto.destination.isBlank()) fly.setDestination(dto.destination);
        if (dto.departure != null) fly.setDeparture(dto.departure);
        repository.update(fly); // TODO: adaptar
        return Optional.of(mapToDTO(fly));
    }

    // Eliminar
    public boolean deleteFly(String id) {
        // puedes usar Borrar DTO si prefieres
        boolean existed = repository.deleteById(id); // TODO: adaptar
        return existed;
    }

    // Mapeo entidad -> DTO (ajusta según Fly)
    private FlyResponseDTO mapToDTO(Fligth fly) {
        return new FlyResponseDTO(
            fly.getId().toString(), // adaptar si id es Identifier
            fly.getOrigin(),
            fly.getDestination(),
            fly.getDeparture(),
            fly.getPlaneId()
        );
    }
}
