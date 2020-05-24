package de.iits.VacationApp.repository;

import de.iits.VacationApp.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface TripRepository extends CrudRepository<Trip, Integer> {
    Trip findAllByTripId(int id);
    @Override
    ArrayList<Trip> findAll();
}
