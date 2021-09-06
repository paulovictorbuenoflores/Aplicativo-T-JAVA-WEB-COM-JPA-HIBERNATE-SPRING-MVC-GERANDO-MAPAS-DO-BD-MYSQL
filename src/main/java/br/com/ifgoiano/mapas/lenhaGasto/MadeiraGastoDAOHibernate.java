/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenhaGasto;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class MadeiraGastoDAOHibernate implements LenhaGastoDAO {
private Session session;
    
    public void setSession(Session session) {
		this.session = session;
	}

    @Override
    public void salvar(MadeiraGasto madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(MadeiraGasto madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(MadeiraGasto madeira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MadeiraGasto carregar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MadeiraGasto buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MadeiraGasto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long buscaTotalMadeira(String madeira) {
         String hql = "select sum(g.valor) from Gastos g where g.estado = :estado";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("madeira", madeira);
    //    JOptionPane.showConfirmDialog(null,""+consulta.list().get(0)+" "+consulta.list().get(0).getClass());
        return (long) consulta.list().get(0);
    }
    
}
