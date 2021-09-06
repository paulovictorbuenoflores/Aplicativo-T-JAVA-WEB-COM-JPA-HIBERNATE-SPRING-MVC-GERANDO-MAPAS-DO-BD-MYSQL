/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenhaGasto;

import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Root
 */
public class MadeiraGastoRN {
    private LenhaGastoDAO madeiraDAO;

	public MadeiraGastoRN() {
		this.madeiraDAO = DAOFactory.criarMadeiraGastoDAO();
	}

	



	public void salvar(MadeiraGasto madeira) {
		
			this.madeiraDAO.salvar(madeira);
		
	}

	public void excluir(MadeiraGasto madeira) {
		this.madeiraDAO.excluir(madeira);
	}

	public List<MadeiraGasto> listar() {
		return this.madeiraDAO.listar();
	}
         
        public long buscaTotalEstado(String madeira) {
        return  this.madeiraDAO.buscaTotalMadeira(madeira);
    }

    
       
     public float buscaPorId(int id) {
        return  this.madeiraDAO.buscarPorId(id).getId();
    }
    
}
