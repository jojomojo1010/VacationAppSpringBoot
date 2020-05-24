package de.iits.VacationApp.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    public int userId;
    public String userName;
    public String password;
    public LocalDateTime singupDate;
    public LocalDateTime lastSignIn;

}
