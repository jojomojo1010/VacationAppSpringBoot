package de.iits.VacationApp.model;


import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
public class Participants {
    @Id
    public int userId;
    public String userName;
    public String password;
}
