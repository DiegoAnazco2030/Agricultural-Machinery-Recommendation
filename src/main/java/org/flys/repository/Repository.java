package org.flys.repository;

import org.flys.business.Identifier;

import java.util.*;
import java.util.function.Predicate;


public interface Repository<T extends Identifier> {

    // Method to save one entity T
    T save(T entity);

    // Method to find one entity for you ID.
    Optional<T> findById(UUID id);

    // Method to obtain all the entitys
    List<T> findAll();

    // Method to delete one entity for you ID
    void deleteById(UUID id);

    // Default method that allows filtering entities based on a predicate
    default List<T> findAll(Predicate<? super T> filter) {
        //We created a list to store the filtered results
        List<T> out = new ArrayList<>();

        // We iterate over all the retrieved entities with findAll()
        for (T t : findAll()) {

            if (filter.test(t)) out.add(t);
        }

        return out;
    }
}
