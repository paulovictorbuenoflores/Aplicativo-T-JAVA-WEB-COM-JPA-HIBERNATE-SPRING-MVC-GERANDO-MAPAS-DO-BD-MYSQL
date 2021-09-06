/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.locais;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class LocaisPK implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "lat")
    private BigDecimal lat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lng")
    private BigDecimal lng;

    public LocaisPK() {
    }

    public LocaisPK(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lat != null ? lat.hashCode() : 0);
        hash += (lng != null ? lng.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocaisPK)) {
            return false;
        }
        LocaisPK other = (LocaisPK) object;
        if ((this.lat == null && other.lat != null) || (this.lat != null && !this.lat.equals(other.lat))) {
            return false;
        }
        if ((this.lng == null && other.lng != null) || (this.lng != null && !this.lng.equals(other.lng))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifgoiano.mapas.locais.LocaisPK[ lat=" + lat + ", lng=" + lng + " ]";
    }
    
}
