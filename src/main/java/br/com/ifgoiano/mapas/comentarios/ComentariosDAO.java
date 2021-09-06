/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.comentarios;

import br.com.ifgoiano.mapas.estados.Estados;
import java.util.List;


public interface ComentariosDAO {
    	public void salvar(Comentarios comentarios);

	public void atualizar(Comentarios comentarios);

	public void excluir(Comentarios comentarios);

	public Comentarios carregar(Integer codigo);

	public Comentarios buscarPorID(int id);

	public List<Comentarios> listar();

    public List<Comentarios> listarPorGasto(int gasto);
}
