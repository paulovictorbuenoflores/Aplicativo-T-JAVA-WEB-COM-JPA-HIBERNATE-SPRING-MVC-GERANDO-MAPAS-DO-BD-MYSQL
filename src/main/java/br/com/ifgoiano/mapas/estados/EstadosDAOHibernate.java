/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.estados;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class EstadosDAOHibernate implements EstadosDAO{
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

        @Override
	public void salvar(Estados estados) {
   		this.session.save(estados);
               
	}

        @Override
	public void atualizar(Estados estados) {
		this.session.update(estados);
	}

        @Override
	public void excluir(Estados estados) {
		this.session.delete(estados);
	}

        @Override
	public Estados carregar(Integer codigo) {
		return (Estados) this.session.get(Estados.class, codigo);
	}

        @Override
	public List<Estados> listar() {
		return this.session.createCriteria(Estados.class).list();
	}

        @Override
	public Estados buscarPorCodigo(String codigo) {
		String hql = "select u from Estados u where u.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("codigo", codigo);
		return (Estados) consulta.uniqueResult();
	}
}    


