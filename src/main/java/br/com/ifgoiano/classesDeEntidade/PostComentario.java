/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade;

import br.com.ifgoiano.usuario.Usuarios;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//import br.com.web.apocalipse.usuario.Usuarios;
/**
 *
 * @author Root
 */
@Entity
@Table(name = "post_comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostComentario.findAll", query = "SELECT p FROM PostComentario p")
    , @NamedQuery(name = "PostComentario.findById", query = "SELECT p FROM PostComentario p WHERE p.id = :id")
    , @NamedQuery(name = "PostComentario.findByReview", query = "SELECT p FROM PostComentario p WHERE p.review = :review")})
public class PostComentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "REVIEW")
    private String review;
    @ManyToMany(mappedBy = "postComentarioCollection")
    private Collection<Post> postCollection;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public PostComentario() {
    }

    public PostComentario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof PostComentario)) {
            return false;
        }
        PostComentario other = (PostComentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classesDeEntidade.PostComentario[ id=" + id + " ]";
    }
    
}
