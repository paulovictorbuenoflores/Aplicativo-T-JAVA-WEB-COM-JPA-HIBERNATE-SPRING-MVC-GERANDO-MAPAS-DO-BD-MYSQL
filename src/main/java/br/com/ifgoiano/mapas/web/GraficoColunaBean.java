package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.estados.Estados;
import br.com.ifgoiano.mapas.estados.EstadosRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@RequestScoped
public class GraficoColunaBean {

	private BarChartModel estadosColunas;

	public GraficoColunaBean() { 
                
				
		this.estadosColunas = new BarChartModel();
                List<Estados> estados;
                estados = new EstadosRN().listar();
                for(Estados e: estados){
                    ChartSeries estadoseries = new ChartSeries();
                    estadoseries.setLabel(e.getCodigo());
                    estadoseries.set(e.getCodigo(), e.getPopulacao());                   
                    this.estadosColunas.addSeries(estadoseries);
                }
		
		this.estadosColunas.setTitle("Gráfico da população do país por estado");
		this.estadosColunas.setLegendPosition("w");
                
		Axis xAxis = this.estadosColunas.getAxis(AxisType.X);
		xAxis.setLabel("Estado");

		Axis yAxis = this.estadosColunas.getAxis(AxisType.Y);
		yAxis.setLabel("População");
		yAxis.setMin(500000);
		yAxis.setMax(48000000);
	}

	public BarChartModel getEstadosColunas() {
		return this.estadosColunas;
	}
}
