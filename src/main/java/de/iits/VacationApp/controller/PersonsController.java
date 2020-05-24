package de.iits.VacationApp.controller;

import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.model.Persons;
import de.iits.VacationApp.repository.ParticipantRepository;
import de.iits.VacationApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController //exposed 4 funktionen (get,post,put,delete)
@RequestMapping("/api/persons") //url die angesprochen werden kann um auf diese klasse zuzugreifen
public class PersonsController {
    PersonRepository personRepository;

    public PersonsController(@Autowired PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public ArrayList<Persons> getAllPersons(){

        return personRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public ArrayList<Persons> findAllByName(@PathVariable String name){
        return personRepository.findAllByName(name);
    }

}
