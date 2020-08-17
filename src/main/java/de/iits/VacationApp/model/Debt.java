package de.iits.VacationApp.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@ToString
@Entity
public class Debt {
    @Id
    public int id;
    @ManyToOne
    public Participants debitor;
    public float credit;

}
