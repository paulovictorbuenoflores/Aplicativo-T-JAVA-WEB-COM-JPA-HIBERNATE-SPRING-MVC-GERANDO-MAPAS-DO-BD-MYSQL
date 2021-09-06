/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.comentarios;

import br.com.ifgoiano.mapas.comentarios.Comentarios;
import br.com.ifgoiano.mapas.comentarios.ComentariosDAO;
import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;


public class ComentariosRN {
    
	private ComentariosDAO comentariosDAO;

	public ComentariosRN() {
		this.comentariosDAO = DAOFactory.criarComentariosDAO();
	}

	

	public Comentarios buscarPorID(int id) {
		return this.comentariosDAO.buscarPorID(id);
	}

	public void salvar(Comentarios comentarios) {
		//int id =  comentarios.getId();
		this.comentariosDAO.salvar(comentarios);
		
	}

	public void excluir(Comentarios comentarios) {
		this.comentariosDAO.excluir(comentarios);
	}

	public List<Comentarios> listar() {
		return this.comentariosDAO.listar();
	}

    public List<Comentarios> listarPorGasto(int gasto) {
        return this.comentariosDAO.listarPorGasto(gasto);
    }
}



