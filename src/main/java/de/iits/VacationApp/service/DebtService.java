package de.iits.VacationApp.service;

import de.iits.VacationApp.model.Debt;
import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.model.Persons;
import de.iits.VacationApp.model.Trip;
import de.iits.VacationApp.repository.ParticipantRepository;
import de.iits.VacationApp.repository.PersonRepository;
import de.iits.VacationApp.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DebtService {
    TripRepository tripRepository;
    ParticipantRepository participantRepository;
    PersonRepository personRepository;


    @Autowired
    public DebtService(TripRepository tripRepository, ParticipantRepository participantRepository, PersonRepository personRepository) {
        this.tripRepository = tripRepository;
        this.participantRepository = participantRepository;
        this.personRepository = personRepository;
        }

        public ArrayList<Debt> calculateDebtByTrip(int tripid){
            ArrayList<Debt> debtsOfTrip = new ArrayList<>();
            Trip currentTrip = tripRepository.findAllByTripId(tripid);

            ArrayList<Participants> participantsByTrip = participantRepository.findAllByTripID(tripid);
            Participants creditor0 = participantsByTrip.stream().filter(participant -> participant.isCreditor).findFirst().get();
            participantsByTrip.remove(creditor0);
            Persons creditor = personRepository.findAllByName(creditor0.name).get(0);
            float share = currentTrip.credit/ (participantsByTrip.size()+1);

            ArrayList<Persons> personsByTrip = new ArrayList<Persons>();
            for (Participants participants : participantsByTrip) {
                personsByTrip.addAll(personRepository.findAllByName(participants.name));
            }

            for (Persons persons : personsByTrip) {
                Debt currentDebt = new Debt(creditor,persons,share);
                System.out.println(currentDebt.toString());
                debtsOfTrip.add(currentDebt);
            }

            return debtsOfTrip;
        }

        public ArrayList<Debt> calculateFinalDebts(){
            ArrayList<Debt> allDebts = new ArrayList<Debt>();
            ArrayList<Debt> finalDebts = new ArrayList<Debt>();
            ArrayList<Persons> personList = new ArrayList<Persons>();
            personList.addAll(personRepository.findAll());

            for (int i = 0 ; i < personList.size() ; i++){
                for (int j=i+1 ; j <personList.size() ; j++){
                    Debt temp = new Debt(personList.get(i), personList.get(j),0);
                    finalDebts.add(temp);
                }
            }

            for (int k=1; k <= tripRepository.findAll().size(); k++) {
                allDebts.addAll(calculateDebtByTrip(k));
            }

            for (Debt finaldebt : finalDebts){
                for (Debt tempdebt : allDebts){
                    if (tempdebt.contains(finaldebt.creditor,finaldebt.debitor) && tempdebt.creditor.name == finaldebt.creditor.name)
                        finaldebt.credit += tempdebt.credit;

                    if (tempdebt.contains(finaldebt.creditor,finaldebt.debitor) && tempdebt.creditor.name != finaldebt.creditor.name)
                        finaldebt.credit -= tempdebt.credit;
                }

            }
            return finalDebts;
        }

        /*bissl mit deletemapping rumprobiert in debtcontroller, funzt noch nicht wirklich
        public ArrayList<Debt> calcFinalDebtWOParticipant(String name, int tripid){
            participantRepository.deleteByNameAndTripID(name, tripid);
            calculateDebtByTrip(tripid);
            return calculateFinalDebts();
        }

        public void calcblabla(){
            //participantRepository.findAllByTripID(1).stream()
        }*/

    }
