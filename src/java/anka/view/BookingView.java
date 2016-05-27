package anka.view;

import anka.logic.BookingLogic;
import anka.logic.FlightLogic;
import anka.model.Booking;
import anka.model.Flight;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named(value = "bookingView")
@RequestScoped
public class BookingView implements Serializable{

    @EJB
    BookingLogic logic;

    Long id;
    String passengerName;


    Date date;
    Flight flight;
    //Booking booking;
    
   
//    
//    List<Flight> flights;
//    
//    Flight flight1 = new Flight(new Airport("ddd"),new Airport("sss"),LocalTime.now(),LocalTime.now().plusHours(2));
//    Flight flight2 = new Flight(new Airport("DDD"),new Airport("sss"),LocalTime.now(),LocalTime.now().plusHours(3));
//
//   
//    
//    

    public void doBook() {
        logic.toBook(passengerName, date);
        
        //logic.toBook(passengerName, date, flight);
    }
    
    public String doDelete(){
        
    logic.toDelete(id);
        System.out.println("BLLLLLLLLLÄ");
    return null;
    }
    
   
    public List<Booking> getBookings() {
        return logic.findAllBookings();
        
    }
    
//    public String toEdit(Booking booking){
//    logic.editBooking(booking);
//    return null;
//    }
//    
    
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Booking edited", "");
        //FacesMessage msg = new FacesMessage("Booking edited", ((Booking)event.getObject()).getId());
    
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Booking Cancelled", "");
    //FacesMessage msg = new FacesMessage("Booking Cancelled", ((Booking)event.getObject()).getId());
    FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    



}
