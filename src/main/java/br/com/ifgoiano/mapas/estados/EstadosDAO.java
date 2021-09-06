/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.estados;

import java.util.List;


public interface EstadosDAO {
  	public void salvar(Estados estados);

	public void atualizar(Estados estados);

	public void excluir(Estados estados);

	public Estados carregar(Integer codigo);

	public Estados buscarPorCodigo(String codigo);

	public List<Estados> listar();
}  

