package de.iits.VacationApp.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    public int userId;
    public String userName;
    public String password;
    public LocalDateTime singupDate;
    public LocalDateTime lastSignIn;

}
