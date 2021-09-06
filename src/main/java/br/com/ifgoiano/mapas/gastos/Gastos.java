/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.gastos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g")
    , @NamedQuery(name = "Gastos.findByCidade", query = "SELECT g FROM Gastos g WHERE g.cidade = :cidade")
    , @NamedQuery(name = "Gastos.findByValor", query = "SELECT g FROM Gastos g WHERE g.valor = :valor")
    , @NamedQuery(name = "Gastos.findByEmpresa", query = "SELECT g FROM Gastos g WHERE g.empresa = :empresa")
    , @NamedQuery(name = "Gastos.findByEstado", query = "SELECT g FROM Gastos g WHERE g.estado = :estado")
    , @NamedQuery(name = "Gastos.findById", query = "SELECT g FROM Gastos g WHERE g.id = :id")})
public class Gastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Gastos() {
    }

    public Gastos(Integer id) {
        this.id = id;
    }

    public Gastos(Integer id, String cidade, long valor, String empresa, String estado) {
        this.id = id;
        this.cidade = cidade;
        this.valor = valor;
        this.empresa = empresa;
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifgoiano.mapas.gastos.Gastos[ id=" + id + " ]";
    }
    
}
