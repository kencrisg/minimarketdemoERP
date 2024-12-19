package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vw_facturacion_meses database table.
 * 
 */
@Entity
@Table(name="vw_facturacion_meses")
@NamedQuery(name="VwFacturacionMes.findAll", query="SELECT v FROM VwFacturacionMes v")
public class VwFacturacionMes implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="fac_emitidas")
	private Long facEmitidas;

	@Id
	private Long id;

	private BigDecimal mes;

	@Column(name="valores_totales")
	private BigDecimal valoresTotales;

	public VwFacturacionMes() {
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public Long getFacEmitidas() {
		return this.facEmitidas;
	}

	public void setFacEmitidas(Long facEmitidas) {
		this.facEmitidas = facEmitidas;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public BigDecimal getValoresTotales() {
		return this.valoresTotales;
	}

	public void setValoresTotales(BigDecimal valoresTotales) {
		this.valoresTotales = valoresTotales;
	}

}