package anka.logic;

import anka.model.Airport;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Krille
 */

@Stateless
public class AirportLogic
{
    
    
    @PersistenceContext
    EntityManager em;
    
    public void save(String name)
    {
        Airport a1 = new Airport(name);
        em.persist(a1);
    }
    
    public List<Airport> getAllAirports() {
        TypedQuery<Airport> query = em.createNamedQuery("findAllAirports", Airport.class);
        return query.getResultList();
    }
}


