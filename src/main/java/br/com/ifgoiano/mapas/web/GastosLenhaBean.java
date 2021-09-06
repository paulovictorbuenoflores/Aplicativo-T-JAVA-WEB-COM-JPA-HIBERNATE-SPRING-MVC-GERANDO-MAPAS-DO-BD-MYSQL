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
import javax.faces.model.SelectItem;

/**
 *
 * @author Root
 */
@ManagedBean(name = "gastosLenhaBean")
@RequestScoped
public class GastosLenhaBean {

    private Madeira gastos = new Madeira();
    private List<Madeira> lista;
    private List<Madeira> listaestado;
    private List<Madeira> listacnpj;
    private List<Madeira> listacnpjAtivo;
    private List<Madeira> gastosPorEstado;
    /*Gastos por estado*/
    private List<String> listacidade;
    private List<SelectItem> estados;
    private List<SelectItem> cidades;
    private String estado;
    private Double qtdareatotal;
    private Double qtdtora;
    private Double qtdlenha;
    private Double qtd;
    private String situacaoCadastral;
    private String razaoSocial;
    private String ano;
    private String cidade;
    private String cnpj;
    private List<Madeira> listaCnpj;

    
    public void setListaestado(List<Madeira> listaestado) {
        this.listaestado = listaestado;
    }
     public void listaGastosEstado() {
        listaestado = this.getLista();
        gastosPorEstado = new ArrayList<>();
        for (Madeira g : listaestado) {
            if (g.getEstado().equals(estado)) {
                gastosPorEstado.add(g);
            }
        }
    }
      /*retorna a lista de cidades para o estado atual*/
    public List<String> getListacidade() {
        listacidade = new ArrayList<String>();
        for (Madeira g : listaestado) {
            if (g.getEstado().equals(estado)) {
                listacidade.add(g.getMunicipio());
            }
        }
        return listacidade;
    }
    public List<Madeira> getListaestado() {
        //Set<Gastos> estados = new HashSet<Gastos>(listaestado);
        //listaestado = new ArrayList<Gastos>(estados);
        return listaestado;
    }
    public List<Madeira> buscarEstado(String est){
                List<Madeira> e = new MadeiraRN().listar();
                for(Madeira g:e)
                {
                    if(est.equals(g.getEstado()))
                        this.listaestado.add(g);
                }
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(e.toString());
		context.addMessage(null, facesMessage);
                return listaestado;
	}
    
      //////////////////Observe AQUI /////////////////
    public List<Madeira> getGastosPorEstado() {
        return gastosPorEstado;
    }

    public void setGastosPorEstado(List<Madeira> gastosSelecionados) {
        this.gastosPorEstado = gastosSelecionados;
    }
////////////////////////////////////////////////////////
    //////////////////////////////////////////
   
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

   
   ////////////////////////////// 

    public void setListacidade(List<String> listacidade) {
        this.listacidade = listacidade;
    }

    public void setEstados(List<SelectItem> estados) {
        this.estados = estados;
    }

    public void setCidades(List<SelectItem> cidades) {
        this.cidades = cidades;
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
  public List<SelectItem> getEstados() {
        SelectItem item = null;
        lista = new MadeiraRN().listar();
        estados = new ArrayList<>();

        if (lista != null) {
            for (Madeira madeira : lista) {
                item = new SelectItem(madeira, madeira.getEstado());
                //item.setEscape(false);
                estados.add(item);
            }
        }
        return estados;
    }
  
  public List<SelectItem> getCidades() {
        SelectItem item = null;
        lista = new MadeiraRN().listar();
        cidades = new ArrayList<SelectItem>();
        if (lista != null) {
            for (Madeira madeira : lista) {
                item = new SelectItem(madeira, madeira.getMunicipio());
                item.setEscape(false);
                cidades.add(item);
            }
        }
        return cidades;
    }
   public String novoE() {
        this.gastos = new Madeira();
        this.lista = new MadeiraRN().listar();
        return "teste.xhtml";
    }
   
     public Madeira getGastos() {
        return gastos;
    }

    public void setGastos(Madeira gastos) {
        this.gastos = gastos;
    }

    public List<Madeira> getLista() {
        return new MadeiraRN().listar();
    }

    public void setLista(List<Madeira> lista) {
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
  
  public float buscarGastosEstado(String codigo) {
        ///busca para mapas
        MadeiraRN gastorn = new MadeiraRN();
        gastos = new Madeira();
        float total = gastorn.buscaTotalEstado(codigo);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(Integer.toString(30));//gastos.getPopulacao()));
        context.addMessage(null, facesMessage);
        return total;
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
    ///
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
     public String exibeInformacoes() {
        List<Madeira> e = new MadeiraRN().listar();
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(e.toString());
        context.addMessage(null, facesMessage);
        return null;
    }

    

   
    
    
     public Double getQtdareatotal() {
        return qtdareatotal;
    }

    public void setQtdareatotal(Double qtdareatotal) {
        this.qtdareatotal = qtdareatotal;
    }

    public Double getQtdtora() {
        return qtdtora;
    }

    public void setQtdtora(Double qtdtora) {
        this.qtdtora = qtdtora;
    }

    public Double getQtdlenha() {
        return qtdlenha;
    }

    public void setQtdlenha(Double qtdlenha) {
        this.qtdlenha = qtdlenha;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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

}
