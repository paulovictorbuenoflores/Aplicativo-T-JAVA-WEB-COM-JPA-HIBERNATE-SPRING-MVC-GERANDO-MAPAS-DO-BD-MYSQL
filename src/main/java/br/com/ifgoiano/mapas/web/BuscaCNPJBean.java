/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.lenha.Madeira;
import br.com.ifgoiano.mapas.lenha.MadeiraRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Root
 */
@ManagedBean(name = "buscacnpjbean")
@RequestScoped
public class BuscaCNPJBean {
    private Madeira gastos = new Madeira();
     private List<Madeira> listacnpj;
     private List<Madeira> lista;
     private List<Madeira> listacnpjAtivo;
      private String situacaoCadastral;
     private String cnpj;
     private String ano;
    private List<Madeira> listaCnpj;

    public Madeira getGastos() {
        return gastos;
    }

    public void setGastos(Madeira gastos) {
        this.gastos = gastos;
    }

    

    public void setLista(List<Madeira> lista) {
        this.lista = lista;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
     public void buscarCnpj() {
       listacnpj = this.getLista();
        listacnpjAtivo = new ArrayList<>();
        for (Madeira g : listacnpj) {
            if ((g.getCnpj().equals(cnpj))&&(g.getAno().equals(ano))) {
                listacnpjAtivo.add(g);
            }
        }
       

    }
    
    public List<Madeira> getListacnpj() {
        return listacnpj;
    }
      public void setListacnpjAtivo(List<Madeira> listacnpjAtivo) {
        this.listacnpjAtivo = listacnpjAtivo;
    }
    public List<Madeira> getListacnpjAtivo() {
        return listacnpjAtivo;
    }
    public void setListacnpj(List<Madeira> listacnpj) {
        this.listacnpj = listacnpj;
    }

     public float buscarAtivoCNPJ(String codigo) {
        MadeiraRN gastorn = new MadeiraRN();
        gastos = new Madeira();
        float total = gastorn.buscaTotalEstado(codigo);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(Integer.toString(30));//gastos.getPopulacao()));
        context.addMessage(null, facesMessage);
        return total;
    }
     public List<Madeira> listar() {
        MadeiraRN gastosrn = new MadeiraRN();
        this.lista = gastosrn.listar();
        return gastosrn.listar();
    }
     
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<Madeira> getListaCnpj() {
        return listaCnpj;
    }

    public void setListaCnpj(List<Madeira> listaCnpj) {
        this.listaCnpj = listaCnpj;
    }
 
    //onde vamos na regra de negocio pegar lista do bd
    public List<Madeira> getLista() {
        return new MadeiraRN().listar();
    }
   
}
