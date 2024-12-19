package minimarketdemo.controller.facturacion.eventos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemoFactEJB.model.entities.Vwevento;
import minimarketdemoFactEJB.model.manager.ManagerFactEvento;

@Named
@SessionScoped
public class BeanFacturacionEventos implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerFactEvento manager;
	
	private List<Vwevento> listaEventos;

	public BeanFacturacionEventos() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void inicializar() {
//		System.out.print(manager.findAllFactEventos());
		listaEventos = manager.findAllFactEventos();
	}
	
	public List<Vwevento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Vwevento> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	
		

}
