/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.gastos;

import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosDAO;
import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;
import org.hibernate.Query;


public class GastosRN {
    
 private GastosDAO gastosDAO;

	public GastosRN() {
		this.gastosDAO = DAOFactory.criarGastosDAO();
	}

	



	public void salvar(Gastos gastos) {
		
			this.gastosDAO.salvar(gastos);
		
	}

	public void excluir(Gastos gastos) {
		this.gastosDAO.excluir(gastos);
	}

	public List<Gastos> listar() {
		return this.gastosDAO.listar();
	}
         
        public long buscaTotalEstado(String estado) {
        return  this.gastosDAO.buscaTotalEstado(estado);
    }

    
    public long buscaTotalCidade(String cidade) {
        return this.gastosDAO.buscaTotalCidade(cidade);
    }
    
     public float buscaPorId(int id) {
        return  this.gastosDAO.buscarPorId(id).getValor();
    }
}



