package anka.logic;

import anka.model.Airport;
import anka.model.Booking;
import java.time.LocalDateTime;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BookingLogic {

    @PersistenceContext
    EntityManager em;
    
    public Booking toBook(String passengerName, LocalDateTime date, Airport ap){
        Booking book = new Booking(passengerName, date, ap);
        em.persist(book);
        return book;
    }
    
    public Booking findBooking(Long id){
        return em.find(Booking.class, id);
        
    }
    
   
    
}
