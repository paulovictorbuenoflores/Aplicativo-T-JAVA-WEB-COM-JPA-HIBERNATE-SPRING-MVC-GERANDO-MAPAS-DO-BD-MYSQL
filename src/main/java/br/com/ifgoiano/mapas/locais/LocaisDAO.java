/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.locais;

import java.util.List;


public interface LocaisDAO {
     	public void salvar(Locais locais);

	public void atualizar(Locais locais);

	public void excluir(Locais locais);

	public Locais carregar(Integer codigo);

	public Locais buscarPorCoor(float lat, float lng);

	public List<Locais> listar(); 

        
}
