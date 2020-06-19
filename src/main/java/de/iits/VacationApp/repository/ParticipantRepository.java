package de.iits.VacationApp.repository;

import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface ParticipantRepository extends CrudRepository<Participants, Integer> {
    ArrayList<Participants> findAllByIsCreditorAndTripID(boolean isCreditor, int TripID);
    @Override
    ArrayList<Participants> findAll();

    ArrayList<Participants> findAllByTripID(int TripID);

    void deleteByNameAndTripID(String ParticipantID, int TripID);




}
