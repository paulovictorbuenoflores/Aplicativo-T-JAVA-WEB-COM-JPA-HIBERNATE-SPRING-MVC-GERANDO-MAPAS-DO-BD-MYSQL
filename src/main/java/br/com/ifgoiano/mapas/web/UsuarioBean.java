package br.com.ifgoiano.mapas.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.com.ifgoiano.usuario.Usuarios;
import br.com.ifgoiano.usuario.UsuarioRN;
//import br.com.ifgoiano.usuarios.util.RNException;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private Usuarios usuario = new Usuarios();
    private String confirmarSenha;
    private List<Usuarios> lista;
    private String destinoSalvar;

    public String novo() {
        this.destinoSalvar = "usuariosucesso";
        this.usuario = new Usuarios();
        this.usuario.setAtivo(true);
        return "/publico/usuario";
    }

    public String editar() {
        this.confirmarSenha = this.usuario.getSenha();
        return "/publico/cadastro";
    }

    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        String senha = this.usuario.getSenha();
        if (!senha.equals(this.confirmarSenha)) {
            FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
            context.addMessage(null, facesMessage);
            return null;
        }

        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
// Envia email aps o cadastramento de um usuario novo
		/*if (this.destinoSalvar.equals("usuariosucesso")) {
			try {
				usuarioRN.enviarEmailPosCadastramento(this.usuario);
			} catch (RNException e) {
				context.addMessage(null, new FacesMessage(e.getMessage()));
				return null;
			}
		}*/
        return this.destinoSalvar;
    }

    public String excluir() {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(this.usuario);
        this.lista = null;
        return null;
    }

    public String ativar() {
        if (this.usuario.isAtivo()) {
            this.usuario.setAtivo(false);
        } else {
            this.usuario.setAtivo(true);
        }

        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        return null;
    }

    public List<Usuarios> getLista() {
        if (this.lista == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listar();
        }
        return this.lista;
    }

    public String atribuiPermissao(Usuarios usuario, String permissao) {
        this.usuario = usuario;
        java.util.Set<String> permissoes = this.usuario.getPermissao();
        if (permissoes.contains(permissao)) {
            permissoes.remove(permissao);
        } else {
            permissoes.add(permissao);
        }
        return null;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

}
