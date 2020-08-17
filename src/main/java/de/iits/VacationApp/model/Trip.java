package de.iits.VacationApp.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {
    @Id
    public int tripId;
    @OneToMany
    public List<Participants> participants = new ArrayList<>();
    @OneToMany
    public List<Debt> debts = new ArrayList<>();

    public double getTotalDebts() {
        return debts.stream()
                .mapToDouble(debt -> debt.credit)
                .sum();
    }

}
