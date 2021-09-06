/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.locais.Locais;
import br.com.ifgoiano.mapas.locais.LocaisRN;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@Named
@RequestScoped
public class AddMarkersView implements Serializable {
     
    private MapModel emptyModel;
      
    private String title;
    
    private List<Locais> locais;
      
    private double lat;
      
    private double lng;
  
    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }
      
    public MapModel getEmptyModel() {
        return emptyModel;
    }
      
    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
  
    public double getLat() {
        return lat;
    }
  
    public void setLat(double lat) {
        this.lat = lat;
    }
  
    public double getLng() {
        return lng;
    }
  
    public void setLng(double lng) {
        this.lng = lng;
    }
      
    public void addMarker() {
        
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }
    
        public void addMarkers() {
        locais = new LocaisRN().listar();
       /* 
        for(Locais l: locais)
        {
            Marker marker = new Marker(new LatLng(l.getLocaisPK().getLat(), (double)l.getLocaisPK().getLng()), "Local");
            emptyModel.addOverlay(marker);
        }
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }
}
}*/
       
        }
}