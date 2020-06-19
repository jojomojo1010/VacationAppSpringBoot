package de.iits.VacationApp.model;


import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
public class Persons {
    @Id
    public int personID;
    public String name;
}
