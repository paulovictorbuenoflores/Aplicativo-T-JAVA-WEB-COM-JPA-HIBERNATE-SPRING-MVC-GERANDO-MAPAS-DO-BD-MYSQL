package br.com.ifgoiano.mapas.util;

import br.com.ifgoiano.mapas.comentarios.ComentariosDAO;
import br.com.ifgoiano.mapas.comentarios.ComentariosDAOHibernate;
import br.com.ifgoiano.mapas.estados.EstadosDAO;
import br.com.ifgoiano.mapas.estados.EstadosDAOHibernate;
import br.com.ifgoiano.mapas.gastos.GastosDAO;
import br.com.ifgoiano.mapas.gastos.GastosDAOHibernate;
import br.com.ifgoiano.mapas.lenha.LenhaDAO;
import br.com.ifgoiano.mapas.lenha.MadeiraDAOHibernate;
import br.com.ifgoiano.mapas.lenhaGasto.LenhaGastoDAO;
import br.com.ifgoiano.mapas.lenhaGasto.MadeiraGastoDAOHibernate;
import br.com.ifgoiano.mapas.locais.LocaisDAO;
import br.com.ifgoiano.mapas.locais.LocaisDAOHibernate;
import br.com.ifgoiano.usuario.UsuarioDAO;
import br.com.ifgoiano.usuario.UsuarioDAOHibernate;
import org.hibernate.HibernateException;

public class DAOFactory {
    public static LenhaGastoDAO criarMadeiraGastoDAO() throws HibernateException {
        MadeiraGastoDAOHibernate madeiraGastoDAO = new   MadeiraGastoDAOHibernate();
        madeiraGastoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return madeiraGastoDAO;
    }
    public static LenhaDAO criarMadeiraDAO() throws HibernateException {
        MadeiraDAOHibernate madeiraDAO = new  MadeiraDAOHibernate();
        madeiraDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return madeiraDAO;
    }
    public static UsuarioDAO criarUsuarioDAO() throws HibernateException {
        UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
    
    public static EstadosDAO criarEstadosDAO() {
       EstadosDAOHibernate estadosDAO = new EstadosDAOHibernate();
		estadosDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estadosDAO;
    }
  public static LocaisDAO criarLocaisDAO() {
       LocaisDAOHibernate locaisDAO = new LocaisDAOHibernate();
		locaisDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());   
		return locaisDAO;
    }

    public static GastosDAO criarGastosDAO() {
       GastosDAOHibernate gastosDAO = new GastosDAOHibernate();
		gastosDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());   
		return gastosDAO;
    }
        
     public static ComentariosDAO criarComentariosDAO() {
       ComentariosDAOHibernate comentariosDAO = new ComentariosDAOHibernate();
		comentariosDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());   
		return comentariosDAO;
    }
}
