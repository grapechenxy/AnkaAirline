package anka.view;

import anka.logic.AirportLogic;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Krille
 */

@Named(value = "airportView")
@RequestScoped
public class AirportView
{
    
    @EJB
    AirportLogic logic;
   
    String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
   
    public void save()
    {
        logic.save(this.name);
    }
}
