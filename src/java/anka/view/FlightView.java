package anka.view;

import anka.logic.FlightLogic;
import anka.model.Airport;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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
    Date dep_time;
    Date arr_time;

    public Airport getDep()
    {
        return dep;
    }

    public void setDep(Airport dep)
    {
        this.dep = dep;
    }

    public Airport getArr()
    {
        return arr;
    }

    public void setArr(Airport arr)
    {
        this.arr = arr;
    }

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
        
    }
    
}
