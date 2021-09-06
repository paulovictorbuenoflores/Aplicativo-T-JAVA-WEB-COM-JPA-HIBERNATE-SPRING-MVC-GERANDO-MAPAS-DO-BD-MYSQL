/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.comentarios;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ComentariosDAOHibernate implements ComentariosDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

        @Override
	public void salvar(Comentarios comentarios) {
            //String hql=" ";
                    
   		this.session.save(comentarios);
               
	}
 
       @Override
	public void atualizar(Comentarios comentarios) {
		this.session.update(comentarios);
	}

        @Override
	public void excluir(Comentarios comentarios) {
		this.session.delete(comentarios);
	}

        @Override
	public Comentarios carregar(Integer codigo) {
		return (Comentarios) this.session.get(Comentarios.class, codigo);
	}

        @Override
	public List<Comentarios> listar() {
		return this.session.createCriteria(Comentarios.class).list();
	}

        @Override
	public Comentarios buscarPorID(int id) {
		String hql = "select u from Comentarios u where u.id = :id";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("id", id);
		return (Comentarios) consulta.uniqueResult();
	}

    @Override
    public List<Comentarios> listarPorGasto(int gasto) {
       		String hql = "select u from Comentarios u where u.idGasto = :gasto";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("gasto", gasto);
		return  consulta.list();
    }
}    


