package anka.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
    private Time dep_time;
    private Time arr_time;
    
    public Flight()
    {
        
    }
    
    public Flight(Airport dep, Airport arr, Time dep_time, Time arr_time)
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
    
    public Time getDep_time()
    {
        return dep_time;
    }
    
    public void setDep_time(Time dep_time)
    {
        this.dep_time = dep_time;
    }
    
    public Time getArr_time()
    {
        return arr_time;
    }
    
    public void setArr_time(Time arr_time)
    {
        this.arr_time = arr_time;
    }
//</editor-fold>
    
    
    
}
