package br.com.ifgoiano.usuario;

//import br.com.web.apocalipse.dao.connection.ConnectionFactory;
import br.com.ifgoiano.mapas.lenha.Madeira;
//import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.EntityManager;
//import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;

public class UsuarioDAOHibernate implements UsuarioDAO {
	private Session session;
      
	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Usuarios usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Usuarios usuario) {
		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			Usuarios usuarioPermissao = this.carregar(usuario.getId());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	public void excluir(Usuarios usuario) {
		this.session.delete(usuario);
	}

	public Usuarios carregar(Integer codigo) {
		return (Usuarios) this.session.get(Usuarios.class, codigo);
	}

	public List<Usuarios> listar() {
		return this.session.createCriteria(Usuarios.class).list();
	}
	public List<Madeira> listarMadeira() {
         //ArrayList<Madeira> madeira=new ArrayList<>();           
       /*      EntityManager em =new ConnectionFactory().getConnection();
      List<Madeira> madeira=null;
 
    
         try{
     madeira= em.createQuery("FROM Madeira c").getResultList();//jpql
         
     }catch(Exception e){
     System.err.println(e);
     }finally{
      em.close(); 
     }*/
       //for(int i=0; i<147564; i++){
       
       
       //madeira=(ArrayList<Madeira>) (List<Madeira>) this.session.createQuery("FROM madeira c");
      // madeira= (ArrayList<Madeira>) this.session.createQuery("FROM madeira");
		return this.session.createCriteria(Madeira.class).list();
       //}
               // return madeira;
                
	}

	public Usuarios buscarPorLogin(String login) {
		String hql = "select u from Usuarios u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuarios) consulta.uniqueResult();
	}

    @Override
    public Usuarios buscarPorEmail(String email) {
       String hql = "select u from Usuarios u where u.email = :email";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("email", email);
               
		return (Usuarios) consulta.uniqueResult();
    }
}
