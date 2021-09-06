/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.locais;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "locais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locais.findAll", query = "SELECT l FROM Locais l")
    , @NamedQuery(name = "Locais.findByLat", query = "SELECT l FROM Locais l WHERE l.locaisPK.lat = :lat")
    , @NamedQuery(name = "Locais.findByLng", query = "SELECT l FROM Locais l WHERE l.locaisPK.lng = :lng")})
public class Locais implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocaisPK locaisPK;

    public Locais() {
    }

    public Locais(LocaisPK locaisPK) {
        this.locaisPK = locaisPK;
    }

    public Locais(BigDecimal lat, BigDecimal lng) {
        this.locaisPK = new LocaisPK(lat, lng);
    }

    public LocaisPK getLocaisPK() {
        return locaisPK;
    }

    public void setLocaisPK(LocaisPK locaisPK) {
        this.locaisPK = locaisPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locaisPK != null ? locaisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locais)) {
            return false;
        }
        Locais other = (Locais) object;
        if ((this.locaisPK == null && other.locaisPK != null) || (this.locaisPK != null && !this.locaisPK.equals(other.locaisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifgoiano.mapas.locais.Locais[ locaisPK=" + locaisPK + " ]";
    }
    
}
