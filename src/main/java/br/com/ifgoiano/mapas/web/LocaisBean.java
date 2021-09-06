/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosRN;
import br.com.ifgoiano.mapas.locais.Locais;
import br.com.ifgoiano.mapas.locais.LocaisRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
 

@ManagedBean(name = "locaisBean")
@RequestScoped
public class LocaisBean{
    
   	private Locais locais = new Locais();
        private List<Locais> l;
	

	public String novoE() {
		this.locais = new Locais();
                this.l=new LocaisRN().listar();
		return "teste.xhtml";
	}
                    
        /*public int buscarLocal(){
            LocaisRN gasto = new LocaisRN();
                locais.setCodigo(codigo);
                Locais e = gasto.buscarPorCodigo(this.locais.getCodigo());
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(e.getPopulacao()));
		context.addMessage(null, facesMessage);
                return e.getPopulacao();
	}*/
        
         public String exibeInformacoes(String codigo){
                List<Locais> e = new LocaisRN().listar();
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(e.toString());
		context.addMessage(null, facesMessage);
                return null;
	}
         
      
}
