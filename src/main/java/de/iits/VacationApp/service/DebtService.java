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

    public ArrayList<Debt> calculateFinalDebts(){
        /*
        Benötigen alle Schulden von allen Trips, wobei diejenigen Schulden mit den selben Personen zusammengefasst
        werden sollen.
        Für alle Trips:
            berechne die Schulden des Trips
        Schulden mit den selben Personen zusammenfassen
         */
        ArrayList<Persons> personList = personRepository.findAll();
        ArrayList<Debt> finalDebts = new ArrayList<Debt>();
        for (int i = 0 ; i < personList.size() ; i++){
            for (int j=i+1 ; j <personList.size() ; j++){
                Debt temp = new Debt(personList.get(i), personList.get(j),0);
                finalDebts.add(temp);
            }
        }

        ArrayList<Debt> allDebts = new ArrayList<Debt>();
        for (int k=1; k <= tripRepository.findAll().size(); k++) {
            allDebts.addAll(calculateDebtByTrip(k));
        }

        mergeDebtsWithSamePersons(allDebts);
        return finalDebts;
    }

    private void mergeDebtsWithSamePersons(ArrayList<Debt> allDebts) {
        ArrayList<Debt> finalDebts = new ArrayList<Debt>();
        HashMap<String,HashMap<String,Float>> debitorToCreditorToDebt = new HashMap<String,HashMap<String,Float>>();
        for (Debt debt : allDebts){
            addDebitorIfNotExists(debitorToCreditorToDebt, debt.debitor);
            addNewDebt(debitorToCreditorToDebt, debt);
        }
        for (Map.Entry<String,HashMap<String,Float>> creditorToDebtEntry : debitorToCreditorToDebt.entrySet()){
            for (Map.Entry<String, Float> debtEntry : creditorToDebtEntry.getValue().entrySet()){
                String debitor = creditorToDebtEntry.getKey();
                String creditor = debtEntry.getKey();
                float credit = debtEntry.getValue();
            }
        }
    }

    private void addNewDebt(HashMap<String, HashMap<String, Float>> debitorToCreditorToDebt, Debt debt) {
        HashMap<String,Float> creditorToDebt = debitorToCreditorToDebt.get(debt.debitor.name);
        if (!creditorToDebt.containsKey(debt.creditor.name)){
            creditorToDebt.put(debt.creditor.name,debt.credit);
        }
        else {
            float currentcredit = creditorToDebt.get(debt.debitor.name);
            creditorToDebt.put(debt.creditor.name, currentcredit + debt.credit);
        }
    }

    private void addDebitorIfNotExists(HashMap<String, HashMap<String, Float>> currentDebts, Persons debitor) {
        if (!currentDebts.containsKey(debitor.name)){
            currentDebts.put(debitor.name, new HashMap<String,Float>());
        }
    }

    private ArrayList<Debt> calculateDebtByTrip(int tripid){
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


        //bissl mit deletemapping rumprobiert in debtcontroller, funzt noch nicht wirklich
        public ArrayList<Debt> calcFinalDebtWOParticipant(String name, int tripid){
            participantRepository.deleteByNameAndTripID(name,tripid);
            return calculateFinalDebts();
        }

}
