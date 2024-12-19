package minimarketdemo.controller.facturacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import minimarketdemoFactEJB.model.entities.VwFacturacionAnio;
import minimarketdemoFactEJB.model.entities.VwFacturacionMes;
import minimarketdemoFactEJB.model.entities.VwPedido;
import minimarketdemoFactEJB.model.manager.ManagerFacturacion;

@Named
@SessionScoped
public class BeanFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ManagerFacturacion managerFactura;

    private List<VwFacturacionAnio> listaFacturacionAnio;
    private List<VwFacturacionMes> listaFacturacionMes;
    private List<VwPedido> listaPedidos;
    private BarChartModel chartFacturacionMes;

    public BeanFacturacion() {
        // Constructor por defecto
    }

    /**
     * Inicializa los datos al cargar el bean.
     */
    
    @PostConstruct
    public void inicializar() {
        cargarFacturacionAnio();
        cargarFacturacionMes();
        cargarPedidos();
        crearModeloGrafico();
    }

    /**
     * Carga los datos de facturación por año.
     */
    public void cargarFacturacionAnio() {
        try {
            listaFacturacionAnio = managerFactura.findAllFacturacionAnio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos de facturación por mes.
     */
    public void cargarFacturacionMes() {
        try {
            listaFacturacionMes = managerFactura.findAllFacturacionMes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos de pedidos.
     */
    public void cargarPedidos() {
        try {
            listaPedidos = managerFactura.findAllPedidos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public List<VwFacturacionAnio> getListaFacturacionAnio() {
        return listaFacturacionAnio;
    }

    public void setListaFacturacionAnio(List<VwFacturacionAnio> listaFacturacionAnio) {
        this.listaFacturacionAnio = listaFacturacionAnio;
    }

    public List<VwFacturacionMes> getListaFacturacionMes() {
        return listaFacturacionMes;
    }

    public void setListaFacturacionMes(List<VwFacturacionMes> listaFacturacionMes) {
        this.listaFacturacionMes = listaFacturacionMes;
    }

    public List<VwPedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<VwPedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    public void crearModeloGrafico() {
        chartFacturacionMes = new BarChartModel();

        ChartSeries facturacion = new ChartSeries();
        facturacion.setLabel("Facturación");

        if (listaFacturacionMes != null) {
            for (VwFacturacionMes mes : listaFacturacionMes) {
                // Usar el nombre del mes como clave
                String nombreMes = obtenerNombreMes(mes.getMes());
                facturacion.set(nombreMes, mes.getValoresTotales());
            }
        }

        chartFacturacionMes.addSeries(facturacion);

        // Configurar el título y la animación
        chartFacturacionMes.setTitle("Facturación Mensual");
        chartFacturacionMes.setLegendPosition("ne");
        chartFacturacionMes.setAnimate(true);

        // Configurar el eje X
        chartFacturacionMes.getAxis(org.primefaces.model.chart.AxisType.X).setLabel("Mes");

        // Configurar el eje Y
        chartFacturacionMes.getAxis(org.primefaces.model.chart.AxisType.Y).setLabel("Total Facturado");
    }

    private String obtenerNombreMes(BigDecimal numeroMes) {
        switch (numeroMes.intValue()) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Desconocido";
        }
    }
   
   
   public BarChartModel getChartFacturacionMes() {
        return chartFacturacionMes;
    }

    public void setChartFacturacionMes(BarChartModel chartFacturacionMes) {
        this.chartFacturacionMes = chartFacturacionMes;
    }
}
