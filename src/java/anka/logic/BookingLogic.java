package anka.logic;

import anka.model.Booking;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BookingLogic {

    @PersistenceContext
    EntityManager em;
    
  
//        public void toBook(String passengerName, Date date, Flight flight){
//        Booking book = new Booking(passengerName, date, flight);
//        em.persist(book);
//        
//    }
//        
                
    public void toBook(String passengerName, Date date){
        Booking book = new Booking(passengerName, date);
        em.persist(book);
        
    }
    
     public String editBooking(Booking booking){
         booking.setCanEdit(true);
         return null;
     
     }
    
    public Booking findBooking(Long id){
        return em.find(Booking.class, id);
    }
    
    public String toDelete(Long id){
    em.remove(id);
    return null;
    
    }
    
    public List<Booking> findAllBookings(){
        TypedQuery<Booking> query = em.createNamedQuery("findAllBookings", Booking.class);
        return query.getResultList();
    }
    
  
    
}
