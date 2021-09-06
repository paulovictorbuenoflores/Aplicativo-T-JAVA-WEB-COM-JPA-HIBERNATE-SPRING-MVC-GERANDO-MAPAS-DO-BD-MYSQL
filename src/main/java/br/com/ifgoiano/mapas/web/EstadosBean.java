/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.estados.Estados;
import br.com.ifgoiano.mapas.estados.EstadosDAO;
import br.com.ifgoiano.mapas.estados.EstadosRN;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sun.net.www.http.HttpClient;



@ManagedBean(name = "estadosBean")
@RequestScoped
public class EstadosBean {
	private Estados estados;
	private String confirmarSenha;

	public String novoE() {
		this.estados = new Estados();
		return "index.jsf";
	}
                    
        public int buscarPopulacao(String codigo){
                EstadosRN estadorn = new EstadosRN();
                estados = new Estados();
                estados = estadorn.buscarPorCodigo(codigo);
    
               // estados = 
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(30));//estados.getPopulacao()));
		context.addMessage(null, facesMessage);
                return estados.getPopulacao();
	
	}
        
         public String exibeInformacoes(String codigo){
                Estados e = new EstadosRN().buscarPorCodigo(codigo);
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(e.toString());
		context.addMessage(null, facesMessage);
                return null;
	}
     /*   public String apiGoogle(){
              String url = "https://maps.googleapis.com/maps/api/geocode/xml?latlng=-26.196223,-52.689523";
                       
       HttpClient httpclient = new DefaultHttpClient();
       HttpGet request = new HttpGet(url);
       InputStream in = httpclient.execute(request).getEntity().getContent();
 
       BufferedReader br = null;
       StringBuilder sb = new StringBuilder();
 
       br = new BufferedReader(new InputStreamReader(in));
 
       String line=null;
            try {
                line = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(EstadosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
 
       while (line != null) {
         sb.append(line);
                  try {
                      line = br.readLine();
                  } catch (IOException ex) {
                      Logger.getLogger(EstadosBean.class.getName()).log(Level.SEVERE, null, ex);
                  }
         }
       return null;
        }	

*/
	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}


