/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.comentarios.Comentarios;
import br.com.ifgoiano.mapas.comentarios.ComentariosRN;
import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosRN;
import br.com.ifgoiano.usuario.UsuarioRN;
import br.com.ifgoiano.usuario.Usuarios;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name = "comentariosBean")
//@SessionScoped
//@NoneScoped 
//@RequestScoped //(padrão), 
//@ViewScoped 
@SessionScoped
public class ComentariosBean {
 Usuarios usuario;
    List<Comentarios> comentarios = new ArrayList<>();

    String comentario;
    String email;
   
   

//HttpServletRequest request;
//HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()request.getRemoteUser();
//request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext();
    public Usuarios buscaUsuarioPorEmail() {
        //String email;
        UsuarioRN usuarioRN = new UsuarioRN();
         usuario = new Usuarios();
       
        email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
       usuario= usuarioRN.buscarPorEmail(email);
        

        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    private int gasto;

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }

    public List<Comentarios> getComentarios() {
        this.comentarios = this.listarComentariosGasto();
        return comentarios;
    }

    /**
     * Creates a new instance of ComentariosBean
     */
    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public ComentariosBean() {
    }

    ////////////////////////////////////////////
    public void adicionar() {
        ComentariosRN comentariosrn = new ComentariosRN();
       usuario= new Usuarios(); 
        usuario=buscaUsuarioPorEmail();
        Comentarios comentarioObj = new Comentarios();
       
        comentarioObj.setCodigoUsuario(usuario.getId());
        comentarioObj.setComentario(comentario);
        comentarioObj.setNomeUser(usuario.getNome());
        comentarioObj.setIdGasto(1);
        comentarioObj.setIdPai(1);
        comentariosrn.salvar(comentarioObj);
    }
    ////////////////////////////////////

    public List<Comentarios> listarComentariosGasto() {
        ComentariosRN comentariosrn = new ComentariosRN();

        FacesContext facesContext = FacesContext.getCurrentInstance();
       int valor;
       String valor2;
       valor2= facesContext.getExternalContext().getRequestParameterMap().get("gasto");
       if(valor2 == null||valor2==""){
       valor2="1";
       }
       valor=Integer.parseInt(valor2);
 this.gasto = valor;
        //this.gasto = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("gasto"));
      
        this.comentarios = comentariosrn.listarPorGasto(this.gasto);

        return this.comentarios;
    }

    public List<Comentarios> listarComentariosGasto(int gasto) {
        ComentariosRN comentariosrn = new ComentariosRN();

        this.comentarios = comentariosrn.listarPorGasto(gasto);
        return this.comentarios;
    }

    public List<Comentarios> listarComentarios() {
        ComentariosRN comentariosrn = new ComentariosRN();
        this.comentarios = comentariosrn.listar();
        return comentarios;
    }
}
