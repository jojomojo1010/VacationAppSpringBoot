package de.iits.VacationApp.model;

import de.iits.VacationApp.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Debt {
    public Persons creditor;
    public Persons debitor;
    public float credit;

    public boolean contains(Persons x , Persons y){
        if (x.name.equals(this.creditor.name) && y.name.equals(this.debitor.name))
            return true;
        return x.name.equals(this.debitor.name) && y.name.equals(this.creditor.name);
    }


}
