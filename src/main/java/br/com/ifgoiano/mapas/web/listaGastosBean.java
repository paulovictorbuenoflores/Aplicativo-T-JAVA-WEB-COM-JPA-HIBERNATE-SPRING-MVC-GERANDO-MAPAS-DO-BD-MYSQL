/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;


import br.com.ifgoiano.mapas.lenha.Madeira;
import br.com.ifgoiano.mapas.lenha.MadeiraRN;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author ROOT
 */

    
@ManagedBean(name = "listaGastosBean")
//@NoneScoped 
//@RequestScoped //(padrão), 
//@ViewScoped 
@SessionScoped 
//@ApplicationScoped
public class listaGastosBean {
    
   	private Madeira madeiraGastos = new Madeira();
        private List<Madeira> listaResultadoBusca;
        private List<Madeira> gastosCidade  = null;
        private List<Madeira> listacidades;
        List<Madeira> listaestado;
        private String estado;
        private String cidade;
        private String empresa;
        private List<String> estados;
        private List<String> cidades;
        private List<String> empresas;
        private boolean excluirmenores;

    public Madeira getMadeiraGastos() {
        return madeiraGastos;
    }

    public void setMadeiraGastos(Madeira madeiraGastos) {
        this.madeiraGastos = madeiraGastos;
    }

    public List<Madeira> getGastosCidade() {
        return gastosCidade;
    }

    public void setGastosCidade(List<Madeira> gastosCidade) {
        this.gastosCidade = gastosCidade;
    }

   public List<String> getEstados() {
        MadeiraRN g= new MadeiraRN();
        return g.listaEstados();
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public List<String> getCidades() {
        MadeiraRN g= new MadeiraRN();
        return g.listaCidades();
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public List<String> getEmpresas() {
        MadeiraRN g= new MadeiraRN();
        return g.listaEmpresas();
    }

    public void setEmpresas(List<String> empresas) {
        this.empresas = empresas;
    }

    public List<Madeira> getListacidades() {
        MadeiraRN g = new MadeiraRN();
        listacidades = g.buscaCidadesEstado(estado);
        return listacidades;
    }

    public void setListacidades(List<Madeira> listacidades) {
        this.listacidades = listacidades;
    }

    public List<Madeira> getListaResultadoBusca() {
        return listaResultadoBusca;
    }

    public void setListaResultadoBusca(List<Madeira> listaResultadoBusca) {
        this.listaResultadoBusca = listaResultadoBusca;
    }

    public boolean isExcluirmenores() {
        return excluirmenores;
    }

    public void setExcluirmenores(boolean excluirmenores) {
        this.excluirmenores = excluirmenores;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public Madeira getGastos() {
        return madeiraGastos;
    }

    public void setGastos(Madeira madeira) {
        this.madeiraGastos = madeira;
    }

    ////////////////////////////////////////////////////////////////////
    /////////////////////// isso nao esta certo!!! /////////////////////
    ///////////////////////////////////////////////////////////////////
    public List<Madeira> getLista() {
        return new MadeiraRN().listar();
    }
////////////////////////////////////////////////////////////////////
    /////////////////////// isso nao esta certo!!! /////////////////////
    ///////////////////////////////////////////////////////////////////
    public void setLista(List<Madeira> lista) {
        this.listaResultadoBusca = lista;
    }
    
    public List<String> atualizaCidades(String estado){
        MadeiraRN g= new MadeiraRN();
        List<Madeira> lista = new ArrayList<>();
        cidades = new ArrayList<>();
      
        for(Madeira e: g.buscaCidadesEstado(estado)){
         cidades.add(e.getMunicipio());
        }
        return cidades;
    }
    
    public List<Madeira> busca(){       
        gastosCidade = new ArrayList<>();
        //listaResultadoBusca = buscarEstado(estado);
        //if(estado.isEmpty() && cidade.isEmpty() && empresa.isEmpty())
        listaResultadoBusca = this.listar();
        List<Madeira> aux = new ArrayList<>();
        if(!estado.isEmpty() && !cidade.isEmpty() && !empresa.isEmpty()){
            for(Madeira g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getMunicipio().equals(cidade) && g.getRazaosocial().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(!estado.isEmpty() && !cidade.isEmpty() && empresa.isEmpty()){
            for(Madeira g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getMunicipio().equals(cidade) )
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(!estado.isEmpty() && cidade.isEmpty() && !empresa.isEmpty()){
             for(Madeira g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getRazaosocial().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(estado.isEmpty() && !cidade.isEmpty() && !empresa.isEmpty()){
            for(Madeira g:listaResultadoBusca)
                if(g.getMunicipio().equals(cidade) && g.getRazaosocial().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        } 
        if(!estado.isEmpty() && cidade.isEmpty() && empresa.isEmpty()){
            for(Madeira g:listaResultadoBusca)
                if(g.getEstado().equals(estado))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
            
        if(estado.isEmpty() && !cidade.isEmpty() && empresa.isEmpty()){
             for(Madeira g:listaResultadoBusca)
                if( g.getMunicipio().equals(cidade) )
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(estado.isEmpty() && cidade.isEmpty() && !empresa.isEmpty()){
            for(Madeira g:listaResultadoBusca)
                if(g.getRazaosocial().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
            
            
        
        return listaResultadoBusca;
    }
    
    public List<Madeira> buscarEstado(String est){
            List<Madeira> e = new MadeiraRN().listar();
            
               listaestado = new ArrayList<Madeira>();
            for(Madeira g:e)
            {
                if(est.equals(g.getEstado()))
                    listaestado.add(g);
            }
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(e.toString());
            context.addMessage(null, facesMessage);
            return listaestado;
	}
    
    public List<Madeira> listar()
    {
        MadeiraRN gastosrn = new MadeiraRN();
        this.listaResultadoBusca = gastosrn.listar();
        return gastosrn.listar();
    }

    
}
