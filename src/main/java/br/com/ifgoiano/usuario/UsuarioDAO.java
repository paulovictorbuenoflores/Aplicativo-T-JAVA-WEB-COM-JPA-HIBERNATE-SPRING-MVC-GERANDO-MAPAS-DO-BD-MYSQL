package br.com.ifgoiano.usuario;

import br.com.ifgoiano.mapas.lenha.Madeira;
import java.util.List;

public interface UsuarioDAO {

    public void salvar(Usuarios usuario);

    public void atualizar(Usuarios usuario);

    public void excluir(Usuarios usuario);

    public Usuarios carregar(Integer codigo);

    public Usuarios buscarPorLogin(String login);
     public Usuarios buscarPorEmail(String email);

    public List<Usuarios> listar();
    
    public List<Madeira> listarMadeira();
}
