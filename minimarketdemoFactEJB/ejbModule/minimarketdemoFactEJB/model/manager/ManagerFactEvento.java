package minimarketdemoFactEJB.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemoFactEJB.model.entities.Vwevento;

/**
 * Session Bean implementation class ManagerFactEvento
 */
@Stateless
@LocalBean
public class ManagerFactEvento {
    @PersistenceContext
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerFactEvento() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Vwevento> findAllFactEventos(){
        Query q;
        List listado;
        String sentenciaJPQL;
        
        sentenciaJPQL = "SELECT o FROM Vwevento o";
        
        q = em.createQuery(sentenciaJPQL);
        listado = q.getResultList();
        
        return listado;
    }

}
