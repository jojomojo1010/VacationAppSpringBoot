package de.iits.VacationApp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {
    @Id
    public int tripId;
    public String user;
    public String name;
    public float credit;
}
