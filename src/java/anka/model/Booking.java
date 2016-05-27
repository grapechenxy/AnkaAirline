
package anka.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllBookings",query= "SELECT b FROM Booking b")
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String passengerName;
    private LocalDateTime date;
    private Airport ap;

    public Booking(){}
    
    public Booking(String passengerName, LocalDateTime date, Airport ap){
    this.passengerName = passengerName;
    this.date = date;
    this.ap = ap;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Airport getAp() {
        return ap;
    }

    public void setAp(Airport ap) {
        this.ap = ap;
    }
    
    
}
