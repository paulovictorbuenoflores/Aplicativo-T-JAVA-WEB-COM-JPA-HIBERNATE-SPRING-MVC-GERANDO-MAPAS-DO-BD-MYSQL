/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByTitulo", query = "SELECT p FROM Post p WHERE p.titulo = :titulo")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITULO")
    private String titulo;
    @JoinTable(name = "post_post_comentario", joinColumns = {
        @JoinColumn(name = "Post_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "comentarios_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<PostComentario> postComentarioCollection;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<PostComentario> getPostComentarioCollection() {
        return postComentarioCollection;
    }

    public void setPostComentarioCollection(Collection<PostComentario> postComentarioCollection) {
        this.postComentarioCollection = postComentarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classesDeEntidade.Post[ id=" + id + " ]";
    }
    
}
