package org.flys.repository;

import org.flys.business.Identifier;

import java.util.*;


// This class implements the Repository interface, providing in-memory storage for entities of type T (which extends Identifiable).
public class InMemoryRepository<T extends Identifier> implements Repository<T> {

    // In-memory storage using a HashMap, where the key is the entity's UUID and the value is the entity itself.
    private final Map<UUID, T> storage = new HashMap<>();

    // Save an entity into the in-memory storage, using the entity's ID as the key.
    @Override
    public T save(T entity) {
        storage.put(entity.getId(), entity);  // Store the entity in the map
        return entity;  // Return the saved entity
    }

    // Find an entity by its UUID (ID). Returns an Optional to handle cases where the entity might not exist.
    @Override
    public Optional<T> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));  // If the entity exists, wrap it in an Optional
    }

    // Get all entities stored in the in-memory map. Converts the map values to a list and returns it.
    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());  // Convert values from the map into a list and return it
    }

    // Delete an entity by its UUID (ID). Removes the entity from the in-memory map.
    @Override
    public void deleteById(UUID id) {
        storage.remove(id);  // Remove the entity from the map using the ID
    }
}
