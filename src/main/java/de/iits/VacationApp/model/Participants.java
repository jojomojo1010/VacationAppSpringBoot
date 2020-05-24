package de.iits.VacationApp.model;


import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Participants {
    @Id
    public int participantID;
    public int tripID;
    public String name;
    public Boolean isCreditor;
}
