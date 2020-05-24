package de.iits.VacationApp.repository;

import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.model.Persons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface PersonRepository extends CrudRepository<Persons, Integer> {
    ArrayList<Persons> findAllByPersonID(int PersonID);
    @Override
    ArrayList<Persons> findAll();

    ArrayList<Persons> findAllByName(String name);


}
