/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade;

import br.com.ifgoiano.usuario.Usuarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
//import br.com.web.apocalipse.usuario.Usuarios;
/**
 *
 * @author Root
 */
@Entity
@Table(name = "registrolog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrolog.findAll", query = "SELECT r FROM Registrolog r")
    , @NamedQuery(name = "Registrolog.findById", query = "SELECT r FROM Registrolog r WHERE r.id = :id")
    , @NamedQuery(name = "Registrolog.findByAcao", query = "SELECT r FROM Registrolog r WHERE r.acao = :acao")
    , @NamedQuery(name = "Registrolog.findByDatahora", query = "SELECT r FROM Registrolog r WHERE r.datahora = :datahora")
    , @NamedQuery(name = "Registrolog.findByDetalhe", query = "SELECT r FROM Registrolog r WHERE r.detalhe = :detalhe")
    , @NamedQuery(name = "Registrolog.findByNome", query = "SELECT r FROM Registrolog r WHERE r.nome = :nome")
    , @NamedQuery(name = "Registrolog.findByStatus", query = "SELECT r FROM Registrolog r WHERE r.status = :status")})
public class Registrolog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ACAO")
    private String acao;
    @Column(name = "DATAHORA")
    @Temporal(TemporalType.DATE)
    private Date datahora;
    @Column(name = "DETALHE")
    private String detalhe;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Registrolog() {
    }

    public Registrolog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Registrolog)) {
            return false;
        }
        Registrolog other = (Registrolog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classesDeEntidade.Registrolog[ id=" + id + " ]";
    }
    
}
