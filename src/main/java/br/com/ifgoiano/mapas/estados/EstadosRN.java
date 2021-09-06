/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.estados;

import java.util.List;
import br.com.ifgoiano.mapas.util.DAOException;
import br.com.ifgoiano.mapas.util.DAOFactory;

public class EstadosRN {

	private EstadosDAO estadosDAO;

	public EstadosRN() {
		this.estadosDAO = DAOFactory.criarEstadosDAO();
	}

	

	public Estados buscarPorCodigo(String codigo) {
		return this.estadosDAO.buscarPorCodigo(codigo);
	}

	public void salvar(Estados estados) {
		String codigo = estados.getCodigo();
		if (codigo == null) {
			this.estadosDAO.salvar(estados);
		} else {
			this.estadosDAO.atualizar(estados);
		}
	}

	public void excluir(Estados estados) {
		this.estadosDAO.excluir(estados);
	}

	public List<Estados> listar() {
		return this.estadosDAO.listar();
	}
}

