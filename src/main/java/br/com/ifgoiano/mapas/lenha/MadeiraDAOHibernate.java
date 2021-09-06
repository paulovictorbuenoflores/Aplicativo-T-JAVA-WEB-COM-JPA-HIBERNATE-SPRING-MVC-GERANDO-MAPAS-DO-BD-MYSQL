/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenha;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Root
 */
public class MadeiraDAOHibernate implements LenhaDAO {
private Session session;
    
    public void setSession(Session session) {
		this.session = session;
	}

    @Override
    public void salvar(Madeira madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Madeira madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Madeira madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Madeira carregar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  @Override
    public List<Madeira> listar() {
         return this.session.createCriteria(Madeira.class).list();
    }
     

    @Override
    public long buscaTotalMadeira(String estado) {
        
        Double x;
       
       String hql = "select sum(g.qtdlenha) from Madeira g where g.estado = :estado";
        //String hql = "select id from Madeira g where g.estado = :estado";
       
       Query consulta = this.session.createQuery(hql);
        consulta.setString("estado", estado);
        //JOptionPane.showConfirmDialog(null,""+consulta.list().get(0)+" "+consulta.list().get(0).getClass());
         x=Double.parseDouble((String) consulta.list().get(0));
        //return (long) consulta.list().get(0);
        long retorno;
        retorno = Math.round(x);
        //retorno;
       return retorno;
    }

    @Override
    public long buscaTotalCidade(String municipio) {
        Double x;
       
        String hql = "select sum(qtdlenha) from Madeira g where g.municipio = :municipio";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("municipio", municipio);       
        x=Double.parseDouble((String) consulta.list().get(0));
        long retorno;
        retorno = Math.round(x);
        //retorno;
       return retorno;
    }
    @Override
    public Madeira buscarPorId(Integer id) {
      String hql = "select g from Madeira g where g.id = :id";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         consulta.setInteger("id", id);//.setString("estado", estado);
         return  (Madeira) consulta.uniqueResult();
    }

//alterei
    @Override
    public Madeira buscarPorCNPJ(String cnpj) {
        
       String hql = "select g from Madeira g where g.cnpj = :cnpj";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         consulta.setString("cnpj", cnpj);//.setString("estado", estado);
         return  (Madeira) consulta.uniqueResult();
    }

    @Override
    public long buscaTotalEstado(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Madeira> buscaCidadesEstado(String estado) {
        
        
      String hql = "select g from Madeira g where g.estado = :estado";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         consulta.setString("estado", estado);//.setString("estado", estado);
         return consulta.list();
    
    
    }

    @Override
    public List<String> listaEstados() {
        
        String hql = "select distinct estado from Madeira";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         return consulta.list();
        
       
    }

    @Override
    public List<String> listaCidades() {
       String hql = "select distinct municipio from Madeira";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         return consulta.list();    }

    @Override
    public List<String> listaEmpresas() {
      
        String hql = "select distinct razaosocial from Madeira";//"select sum(g.valor) from gastos g where g.estado = :estado";
         Query consulta = this.session.createQuery(hql);
         return consulta.list();
    }
    
}
