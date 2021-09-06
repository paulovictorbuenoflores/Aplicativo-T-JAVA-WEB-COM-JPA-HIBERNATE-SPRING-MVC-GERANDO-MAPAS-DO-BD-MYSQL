package br.com.ifgoiano.usuario;

import br.com.ifgoiano.mapas.lenha.Madeira;
import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;
//import br.com.ifgoiano.usuarios.util.DAOFactory;
//import br.com.ifgoiano.usuarios.util.RNException;
import java.util.Locale;
//import br.com.web.apocalipse.filter.web.util.EmailUtil;
//import br.com.web.apocalipse.filter.web.util.MensagemUtil;
import br.com.ifgoiano.usuario.criptografia.MyAES;
//import br.com.ifgoiano.usuarios.util.UtilException;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuarios carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuarios buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	} 
        public Usuarios buscarPorEmail(String email) {
		return this.usuarioDAO.buscarPorEmail(email);
	} 

	public void salvar(Usuarios usuario) {
            MyAES aes = new MyAES();
           
		Integer codigo = usuario.getId();
		if (codigo == null || codigo == 0) {
                    
			usuario.getPermissao().add("ROLE_USUARIO");
                        String chave = aes.genKey(usuario.getSenha().length());
                         aes.criptografa(usuario.getSenha(),chave);
                        
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
                
	}
/*
	public void enviarEmailPosCadastramento(Usuarios usuario) throws RNException {
		// Enviando um e-mail conforme o idioma do usu�rio
		String[] info = usuario.getIdioma().split("_");
                Locale locale = new Locale(info[0], info[1]);
		String titulo = MensagemUtil.getMensagem(locale, "email_titulo");
                String mensagem = MensagemUtil.getMensagem(locale, "email_mensagem", usuario.getNome(), usuario.getEmail(), usuario.getSenha());//n esta encontrando
		try {
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.enviarEmail(null, usuario.getEmail(), titulo, mensagem);
		} catch (UtilException e) {
			throw new RNException(e);
		}
	}*/

	public void excluir(Usuarios usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuarios> listar() {
		return this.usuarioDAO.listar();
	}
	public List<Madeira> listarMadeira() {
		return this.usuarioDAO.listarMadeira();
	}
}
