/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;



    
@ManagedBean(name = "gastosBean")
@RequestScoped
public class GastosBean {
    
   	private Gastos gastos = new Gastos();
        private List<Gastos> lista;
        
        private List<SelectItem> estados;
        private List<SelectItem> cidades;
        private String estado;
        private String cidade;

   
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
        

        public List<SelectItem> getEstados () {
		SelectItem item = null;
                lista = new GastosRN().listar();
                estados = new ArrayList<>();
                
		if (lista != null) {
			for (Gastos gasto : lista) {
				item = new SelectItem(gasto, gasto.getEstado());
				//item.setEscape(false);
				estados.add(item);                                
			}
		}
                return estados;
	}
        
        public List<SelectItem> getCidades() {
		SelectItem item = null;
                lista = new GastosRN().listar();
                cidades = new ArrayList<SelectItem>();
		if (lista != null) {
			for (Gastos gasto : lista) {
				item = new SelectItem(gasto, gasto.getCidade());
				item.setEscape(false);
				cidades.add(item);				
			}
		}
                    return cidades;
	}
	

	public String novoE() {
		this.gastos = new Gastos();
                this.lista=new GastosRN().listar();
		return "teste.xhtml";
	}

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }

    public List<Gastos> getLista() {
        return new GastosRN().listar();
    }

    public void setLista(List<Gastos> lista) {
        this.lista = lista;
    }
                    
        /*public int buscarLocal(){
            GastosRN estado = new GastosRN();
                gastos.setCodigo(codigo);
                Gastos e = estado.buscarPorCodigo(this.gastos.getCodigo());
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(e.getPopulacao()));
		context.addMessage(null, facesMessage);
                return e.getPopulacao();
	}*/
        
         public String exibeInformacoes(){
                List<Gastos> e = new GastosRN().listar();
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(e.toString());
		context.addMessage(null, facesMessage);
                return null;
	}
         
            public float buscarGastosEstado(String codigo){
                GastosRN gastorn = new GastosRN();
                gastos = new Gastos();
                float total = gastorn.buscaTotalEstado(codigo);
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(30));//gastos.getPopulacao()));
		context.addMessage(null, facesMessage);
                return total;
      
	
	}
            public List<Gastos> listar()
            {
                GastosRN gastosrn = new GastosRN();
                this.lista = gastosrn.listar();
                return gastosrn.listar();
            }
}

