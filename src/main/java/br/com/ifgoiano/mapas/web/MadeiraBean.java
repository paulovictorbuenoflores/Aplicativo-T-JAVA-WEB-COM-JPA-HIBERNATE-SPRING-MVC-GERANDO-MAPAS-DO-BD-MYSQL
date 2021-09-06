/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

//import br.com.web.apocalipse.classesDeEntidade.Madeira;
import br.com.ifgoiano.mapas.lenha.Madeira;
import br.com.ifgoiano.usuario.UsuarioRN;
import br.com.ifgoiano.usuario.Usuarios;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Root
 */
@ManagedBean(name = "MadeiraBean")
@RequestScoped
public class MadeiraBean {
     private List<Madeira> lista;
     public List<Madeira> getLista() {
        if (this.lista == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listarMadeira();
        }
        return this.lista;
    }
     
      
   
    
    
    
   private StreamedContent grafico;
	private static final Logger	log	= Logger.getLogger(MadeiraBean.class.getName());

	public MadeiraBean() {
		try {
			JFreeChart graficoColunas = ChartFactory.createBarChart("Exploração de madeira por estado",
				"ESTADO", "Brasil", this.dados(), PlotOrientation.VERTICAL, false, true, false); 
			File arquivoGrafico = new File("colunas.png");
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 325);
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png");
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}

	
	public StreamedContent getGrafico() {
		return this.grafico;
	}

   private DefaultCategoryDataset dados() {
       List<Madeira> lista;
   DefaultCategoryDataset dcd =new DefaultCategoryDataset();
   lista=getLista();
   
   for(int i=0; i<lista.size(); i++){
       
       if("GOIAS".equals(lista.get(i).getEstado())||"goias".equals(lista.get(i).getEstado())||"GO".equals(lista.get(i).getEstado())){
       Double soma=+Double.parseDouble(lista.get(i).getQtdlenha());
       
   dcd.setValue(soma, "Exploração", lista.get(i).getMunicipio());	
       //System.out.println(lista);
       }
       
   }
   
   
   return dcd;
   }
     
     
}
