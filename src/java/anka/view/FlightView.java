package anka.view;

import anka.logic.FlightLogic;
import anka.model.Airport;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Krille
 */

@Named(value = "flightView")
@RequestScoped
public class FlightView
{
    @EJB
    FlightLogic logic;
    
    List<Airport> airports = new ArrayList<>();
    
    Airport dep;
    Airport arr;
    LocalTime dep_time;
    LocalTime arr_time;
    
    
}
