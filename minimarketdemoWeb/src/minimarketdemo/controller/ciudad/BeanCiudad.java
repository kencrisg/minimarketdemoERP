package minimarketdemo.controller.ciudad;

import minimarketdemo.model.core.entities.EstCiudad;
import minimarketdemo.model.ciudad.managers.ManagerCiudad;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanCiudad implements Serializable {

	@Inject
	private ManagerCiudad managerCiudad; 

	private EstCiudad ciudad;
	private List<EstCiudad> listaCiudades;

	public BeanCiudad() {
		ciudad = new EstCiudad();
	}

	public EstCiudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(EstCiudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<EstCiudad> getListaCiudades() {
		listaCiudades = managerCiudad.obtenerTodasCiudades();
		return listaCiudades;
	}

	public String crearCiudad() {
		if (ciudad != null) {
			managerCiudad.crearCiudad(ciudad.getNombre(), ciudad.getCodigoPostal());
			ciudad = new EstCiudad();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Ciudad creada correctamente."));
		}
		return null;
	}

	public String actualizarCiudad() {
		if (ciudad != null) {
			managerCiudad.actualizarCiudad(ciudad.getId(), ciudad.getNombre(), ciudad.getCodigoPostal());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Ciudad actualizada correctamente."));
		}
		return null; 
	}

	public String eliminarCiudad(Integer id) {
		if (id != null) {
			managerCiudad.eliminarCiudad(id);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Ciudad eliminada correctamente."));
		}
		return null; 
	}

	public void cargarCiudad(Integer id) {
		ciudad = managerCiudad.obtenerCiudadPorId(id);
	}
}
