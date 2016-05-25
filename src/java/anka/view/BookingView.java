package anka.view;

import anka.logic.BookingLogic;
import anka.model.Airport;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "BookingView")
@RequestScoped
public class BookingView {

    @EJB
    BookingLogic logic;

    private String passengerName;
    private LocalDateTime date;
    private Airport ap;
    private List<Airport> aps;
    
    

    public void doBook() {
        logic.toBook(passengerName, date, ap);
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
