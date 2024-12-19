package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vwevento database table.
 * 
 */
@Entity
@Table(name="vwevento")
@NamedQuery(name="Vwevento.findAll", query="SELECT v FROM Vwevento v")
public class Vwevento  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(length=200)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	@Id
	@Column(name="id_evento")
	private Integer idEvento;

	@Column(name="id_usuario", length=20)
	private String idUsuario;

	public Vwevento() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}