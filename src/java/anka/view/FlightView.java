package anka.view;

import anka.logic.AirportLogic;
import anka.logic.FlightLogic;
import anka.model.Airport;
import anka.model.Flight;
import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Krille
 */

@Named(value = "flightView")
@ViewScoped
public class FlightView implements Serializable
{
    @EJB
    FlightLogic logic;
    
    @EJB
    AirportLogic airlogic;
    
    
    List<Airport> airports;
    Long depID;
    Long arrID;
    Date dep_time;
    Date arr_time;
    

    public Date getDep_time()
    {
        return dep_time;
    }

    public void setDep_time(Date dep_time)
    {
        this.dep_time = dep_time;
    }

    public Date getArr_time()
    {
        return arr_time;
    }

    public void setArr_time(Date arr_time)
    {
        this.arr_time = arr_time;
    }
    
    public Long getDepID()
    {
        return depID;
    }

    public void setDepID(Long dep)
    {
        this.depID = dep;
    }

    public Long getArrID()
    {
        return arrID;
    }

    public void setArrID(Long arr)
    {
        this.arrID = arr;
    }
    
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public void save()
    {
        Time sqlTime_dep = new Time(dep_time.getTime());
        Time sqlTime_arr = new Time(arr_time.getTime());
        
        Flight f1 = new Flight(getAirportFromID(depID), getAirportFromID(arrID), sqlTime_dep, sqlTime_arr);
        logic.save(f1);
    }
    
    public List<Long> getAllAirportIDs() 
    {
        //System.out.println(logic.getAllAirports().get(0).getName());
        airports = airlogic.getAllAirports();
        List<Long> idlist = new ArrayList<>();
        for(Airport air : airports)
        {
            idlist.add(air.getId());
        }
        return idlist;
    }
    
    public Airport getAirportFromID(long id)
    {
        //System.out.println("Finding ID: " + id);
        for(Airport air: airports)
        {
            if(air.getId() == id)
            {
                //System.out.println("Found: " + air.getName());
                return air;   
            }
        }
        return null;
    }
}
