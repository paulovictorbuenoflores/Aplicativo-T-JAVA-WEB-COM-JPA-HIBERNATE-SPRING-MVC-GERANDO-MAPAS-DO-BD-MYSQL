/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenha;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "madeira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Madeira.findAll", query = "SELECT m FROM Madeira m")
    , @NamedQuery(name = "Madeira.findById", query = "SELECT m FROM Madeira m WHERE m.id = :id")
    , @NamedQuery(name = "Madeira.findByAno", query = "SELECT m FROM Madeira m WHERE m.ano = :ano")
    , @NamedQuery(name = "Madeira.findByCnpj", query = "SELECT m FROM Madeira m WHERE m.cnpj = :cnpj")
    , @NamedQuery(name = "Madeira.findByEstado", query = "SELECT m FROM Madeira m WHERE m.estado = :estado")
    , @NamedQuery(name = "Madeira.findByMunicipio", query = "SELECT m FROM Madeira m WHERE m.municipio = :municipio")
    , @NamedQuery(name = "Madeira.findByQtdareatotal", query = "SELECT m FROM Madeira m WHERE m.qtdareatotal = :qtdareatotal")
    , @NamedQuery(name = "Madeira.findByQtdlenha", query = "SELECT m FROM Madeira m WHERE m.qtdlenha = :qtdlenha")
    , @NamedQuery(name = "Madeira.findByQtdtora", query = "SELECT m FROM Madeira m WHERE m.qtdtora = :qtdtora")
    , @NamedQuery(name = "Madeira.findByRazaosocial", query = "SELECT m FROM Madeira m WHERE m.razaosocial = :razaosocial")
    , @NamedQuery(name = "Madeira.findBySituacaocadastral", query = "SELECT m FROM Madeira m WHERE m.situacaocadastral = :situacaocadastral")})
public class Madeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ANO")
    private String ano;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "MUNICIPIO")
    private String municipio;
    @Column(name = "QTDAREATOTAL")
    private String qtdareatotal;
    @Column(name = "QTDLENHA")
    private String qtdlenha;
    @Column(name = "QTDTORA")
    private String qtdtora;
    @Column(name = "RAZAOSOCIAL")
    private String razaosocial;
    @Column(name = "SITUACAOCADASTRAL")
    private String situacaocadastral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getQtdareatotal() {
        return qtdareatotal;
    }

    public void setQtdareatotal(String qtdareatotal) {
        this.qtdareatotal = qtdareatotal;
    }

    public String getQtdlenha() {
        return qtdlenha;
    }

    public void setQtdlenha(String qtdlenha) {
        this.qtdlenha = qtdlenha;
    }

    public String getQtdtora() {
        return qtdtora;
    }

    public void setQtdtora(String qtdtora) {
        this.qtdtora = qtdtora;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getSituacaocadastral() {
        return situacaocadastral;
    }

    public void setSituacaocadastral(String situacaocadastral) {
        this.situacaocadastral = situacaocadastral;
    }

   

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.ano);
        hash = 53 * hash + Objects.hashCode(this.cnpj);
        hash = 53 * hash + Objects.hashCode(this.estado);
        hash = 53 * hash + Objects.hashCode(this.municipio);
        hash = 53 * hash + Objects.hashCode(this.qtdareatotal);
        hash = 53 * hash + Objects.hashCode(this.qtdlenha);
        hash = 53 * hash + Objects.hashCode(this.qtdtora);
        hash = 53 * hash + Objects.hashCode(this.razaosocial);
        hash = 53 * hash + Objects.hashCode(this.situacaocadastral);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Madeira other = (Madeira) obj;
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (!Objects.equals(this.qtdareatotal, other.qtdareatotal)) {
            return false;
        }
        if (!Objects.equals(this.qtdlenha, other.qtdlenha)) {
            return false;
        }
        if (!Objects.equals(this.qtdtora, other.qtdtora)) {
            return false;
        }
        if (!Objects.equals(this.razaosocial, other.razaosocial)) {
            return false;
        }
        if (!Objects.equals(this.situacaocadastral, other.situacaocadastral)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  


    @Override
    public String toString() {
        return "Madeira{" + "id=" + id + ", ano=" + ano + ", cnpj=" + cnpj + ", estado=" + estado + ", municipio=" + municipio + ", qtdareatotal=" + qtdareatotal + ", qtdlenha=" + qtdlenha + ", qtdtora=" + qtdtora + ", razaosocial=" + razaosocial + ", situacaocadastral=" + situacaocadastral + '}';
    }
   
}
