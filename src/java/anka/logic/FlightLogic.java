package anka.logic;

import anka.model.Airport;
import anka.model.Flight;
import java.time.LocalTime;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Krille
 */

@Stateless
public class FlightLogic
{
    @PersistenceContext
    EntityManager em;
    
    public void save(Flight f1)
    {
        em.persist(f1);
    }
}
