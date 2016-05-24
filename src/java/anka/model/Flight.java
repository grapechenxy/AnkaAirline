package anka.model;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Krille
 */
@Entity
public class Flight implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @ManyToOne
    private Airport departure;
    @ManyToOne
    private Airport arrival;
    private LocalTime dep_time;
    private LocalTime arr_time;
    
    public Flight()
    {
        
    }
    
    public Flight(Airport dep, Airport arr, LocalTime dep_time, LocalTime arr_time)
    {
        this.departure = dep;
        this.arrival = arr;
        this.dep_time = dep_time;
        this.arr_time = arr_time;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Get&Set">
    public Airport getDeparture()
    {
        return departure;
    }
    
    public void setDeparture(Airport departure)
    {
        this.departure = departure;
    }
    
    public Airport getArrival()
    {
        return arrival;
    }
    
    public void setArrival(Airport arrival)
    {
        this.arrival = arrival;
    }
    
    public LocalTime getDep_time()
    {
        return dep_time;
    }
    
    public void setDep_time(LocalTime dep_time)
    {
        this.dep_time = dep_time;
    }
    
    public LocalTime getArr_time()
    {
        return arr_time;
    }
    
    public void setArr_time(LocalTime arr_time)
    {
        this.arr_time = arr_time;
    }
//</editor-fold>
    
    
    
}
