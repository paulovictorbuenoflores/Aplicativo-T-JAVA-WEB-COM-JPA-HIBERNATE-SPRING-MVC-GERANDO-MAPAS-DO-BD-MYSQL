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
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@Named
@ViewScoped
public class MarkerSelectionView implements Serializable {
     
    private MapModel simpleModel;
  
    private Marker marker;
    private List<Locais> locais;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        locais = new LocaisRN().listar();
        
        for(Locais l: locais){
            LatLng coord1 = new LatLng(l.getLocaisPK().getLat().doubleValue(),l.getLocaisPK().getLng().doubleValue());
            simpleModel.addOverlay(new Marker(coord1, "UBS"));    
        }
     
    }
      
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
}