/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenhaGasto;

import java.util.List;


public interface LenhaGastoDAO {
     public void salvar(MadeiraGasto madeira);

	public void atualizar(MadeiraGasto madeira);

	public void excluir(MadeiraGasto madeira);

	public MadeiraGasto carregar(Integer codigo);

	public MadeiraGasto buscarPorId(Integer id);

	public List<MadeiraGasto> listar(); 
        
        public long buscaTotalMadeira(String madeira);
        
        //public long buscaTotalCidade(String cidade);
}
