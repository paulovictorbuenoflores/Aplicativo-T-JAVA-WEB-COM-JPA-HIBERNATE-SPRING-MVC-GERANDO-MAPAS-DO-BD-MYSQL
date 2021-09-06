/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.locais;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class LocaisDAOHibernate implements LocaisDAO{
 private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

        @Override
	public void salvar(Locais locais) {
   		this.session.save(locais);
               
	}

        @Override
	public void atualizar(Locais locais) {
		this.session.update(locais);
	}

        @Override
	public void excluir(Locais locais) {
		this.session.delete(locais);
	}

        @Override
	public Locais carregar(Integer codigo) {
		return (Locais) this.session.get(Locais.class, codigo);
	}

        @Override
	public List<Locais> listar() {
		return this.session.createCriteria(Locais.class).list();
	}

        @Override
	public Locais buscarPorCoor(float lat,  float lng) {
		String hql = "select u from Locais u where u.lat = :lat and u.lng = :lng";
		Query consulta = this.session.createQuery(hql);
		consulta.setFloat("lat", lat);
                consulta.setFloat("lng", lng);
		return (Locais) consulta.uniqueResult();
	}

 
}    


   

