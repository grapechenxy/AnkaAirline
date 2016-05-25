package anka.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Krille
 */

@Entity
@NamedQuery(name = "findAllAirports",query= "SELECT a FROM Airport a")
public class Airport implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "departure")
    private List<Flight> departures;
    
    @OneToMany(mappedBy = "arrival")
    private List<Flight> arrivals;

    public Airport()
    {
       
    }
    
    public Airport(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Get&Set">
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
//</editor-fold>
    
    
    
}
