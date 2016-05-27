
package anka.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "findAllBookings",query= "SELECT b FROM Booking b")
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String passengerName;
    
   
    private Date date;
    
    
    private Flight flight;
    
    private boolean canEdit;

 


    

    public Booking(){}
    
    public Booking(String passengerName, Date date, Flight flight){
    this.passengerName = passengerName;
    this.date = date;
    this.flight = flight;
    canEdit = false;
    }
    
    public Booking(String passengerName, Date date){
    this.passengerName = passengerName;
    this.date = date;
    canEdit = false;
    
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
   public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    
}
