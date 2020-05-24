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
        if (x.name == this.creditor.name && y.name == this.debitor.name)
            return true;
        if (x.name == this.debitor.name && y.name == this.creditor.name)
            return true;
        return false;
    }


}
