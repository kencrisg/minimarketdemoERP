package minimarketdemoFactEJB.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemoFactEJB.model.entities.VwFacturacionAnio;
import minimarketdemoFactEJB.model.entities.VwFacturacionMes;
import minimarketdemoFactEJB.model.entities.VwPedido;

/**
 * Session Bean implementation class ManagerFacturacion
 */
@Stateless
@LocalBean
public class ManagerFacturacion {

	@PersistenceContext
    private EntityManager em;
	
    public ManagerFacturacion() {
		
	}

	/**
     * Obtiene todas las facturaciones agrupadas por año.
     * @return Lista de VwFacturacionAnio.
     */
    public List<VwFacturacionAnio> findAllFacturacionAnio() {
        String jpql = "SELECT o FROM VwFacturacionAnio o";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Obtiene todas las facturaciones agrupadas por mes.
     * @return Lista de VwFacturacionMes.
     */
    public List<VwFacturacionMes> findAllFacturacionMes() {
        String jpql = "SELECT o FROM VwFacturacionMes o";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }
    /**
     * Obtiene todos los pedidos.
     * @return Lista de VwPedido.
     */
    public List<VwPedido> findAllPedidos() {
        String jpql = "SELECT o FROM VwPedido o";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }
}
