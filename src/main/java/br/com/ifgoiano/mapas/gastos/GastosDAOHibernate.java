/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.gastos;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;


public class GastosDAOHibernate implements GastosDAO{

    private Session session;
    
    public void setSession(Session session) {
		this.session = session;
	}

    @Override
    public void salvar(Gastos gastos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Gastos gastos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Gastos gastos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gastos carregar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Gastos> listar() {
        return this.session.createCriteria(Gastos.class).list();
    }

      
	
     @Override
    public long buscaTotalEstado(String estado) {
        String hql = "select sum(g.valor) from Gastos g where g.estado = :estado";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("estado", estado);
    //    JOptionPane.showConfirmDialog(null,""+consulta.list().get(0)+" "+consulta.list().get(0).getClass());
        return (long) consulta.list().get(0);
    }

    @Override
    public long buscaTotalCidade(String cidade) {
        String hql = "select sum(valor) from gastos g where g.cidade = :cidade";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("cidade", cidade);       
        return (long) consulta.list().get(0);
    }  

    @Override
    public Gastos buscarPorId(Integer id) {
        String hql = "select g from Gastos g where g.id = :id";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         consulta.setInteger("id", id);//.setString("estado", estado);
         return  (Gastos) consulta.uniqueResult();
    }

   
}





