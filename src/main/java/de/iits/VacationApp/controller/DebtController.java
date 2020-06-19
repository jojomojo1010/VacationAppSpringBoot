package de.iits.VacationApp.controller;

import de.iits.VacationApp.model.Debt;
import de.iits.VacationApp.model.Participants;
import de.iits.VacationApp.repository.ParticipantRepository;
import de.iits.VacationApp.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController //exposed 4 funktionen (get,post,put,delete)
@RequestMapping("/api/debt") //url die angesprochen werden kann um auf diese klasse zuzugreifen
public class DebtController {
    DebtService debtService;

    public DebtController(@Autowired DebtService debtService){
        this.debtService = debtService;
    }

    @GetMapping(value = "/{tripid}")
    public ArrayList<Debt> getCreditorByTrip(@PathVariable int tripid){
        return debtService.calculateDebtByTrip(tripid);
    }
    @GetMapping(value = "/final")
    public ArrayList<Debt> getAllDebts(){
        return debtService.calculateFinalDebts();
    }

    @DeleteMapping(value = "/{name}}/{tripid}") //klappt noch nicht ganz
    public ArrayList<Debt> getAllDebtsWOParticipant(@PathVariable String name, int tripid){
        return debtService.calcFinalDebtWOParticipant(name,tripid);
    }
}
