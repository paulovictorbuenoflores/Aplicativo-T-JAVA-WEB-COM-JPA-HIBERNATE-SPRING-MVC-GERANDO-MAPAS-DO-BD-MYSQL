/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.locais;

import br.com.ifgoiano.mapas.locais.Locais;
import br.com.ifgoiano.mapas.locais.LocaisDAO;
import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;


public class LocaisRN {
    private LocaisDAO locaisDAO;

	public LocaisRN() {
		this.locaisDAO = DAOFactory.criarLocaisDAO();
	}

	

	public Locais buscarPorCodigo(float lat, float lng) {
		return this.locaisDAO.buscarPorCoor(lat, lng);
	}

	public void salvar(Locais locais) {
		
			this.locaisDAO.salvar(locais);
		
	}

	public void excluir(Locais locais) {
		this.locaisDAO.excluir(locais);
	}

	public List<Locais> listar() {
		return this.locaisDAO.listar();
	}
}


