package de.iits.VacationApp.controller;

import de.iits.VacationApp.model.Debt;
import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.model.Trip;
import de.iits.VacationApp.repository.ParticipantRepository;
import de.iits.VacationApp.repository.TripRepository;
import de.iits.VacationApp.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController //exposed 4 funktionen (get,post,put,delete)
@RequestMapping("/api/trips") //url die angesprochen werden kann um auf diese klasse zuzugreifen
public class TripController {
    TripRepository tripRepository;
    ParticipantRepository participantRepository;

    public TripController(@Autowired TripRepository tripRepository, ParticipantRepository participantRepository) {
        this.tripRepository = tripRepository;
        this.participantRepository = participantRepository;
    }

    @GetMapping //legt die http anfrage fest (get oder post oder kp)
    public ArrayList<Trip> showAllTrips() {

        return tripRepository.findAll();
    }

    @GetMapping(value = "/participants/{tripid}")
    public ArrayList<Participants> participantsOfTrip(@PathVariable int tripid) {

        return participantRepository.findAllByTripID(tripid);
    }

    @GetMapping(value = "/tripcreditor/{tripid}")
    public ArrayList<Participants> getCreditorOfTrip(@PathVariable int tripid) {

        return participantRepository.findAllByIsCreditorAndTripID(true, tripid);
    }
}

