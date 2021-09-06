/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenha;

import br.com.ifgoiano.mapas.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Root
 */
public class MadeiraRN {
    private LenhaDAO madeiraDAO;

	public MadeiraRN() {
		this.madeiraDAO = DAOFactory.criarMadeiraDAO();
	}

	



	public void salvar(Madeira madeira) {
		
			this.madeiraDAO.salvar(madeira);
		
	}

	public void excluir(Madeira madeira) {
		this.madeiraDAO.excluir(madeira);
	}

	public List<Madeira> listar() {
		return this.madeiraDAO.listar();
	}
         
        public long buscaTotalEstado(String madeira) {
        return  this.madeiraDAO.buscaTotalMadeira(madeira);
    }
      
 public long buscaTotalCidade(String cidade) {
        return this.madeiraDAO.buscaTotalCidade(cidade);
    }

    
       
     public float buscaPorId(int id) {
        return  this.madeiraDAO.buscarPorId(id).getId();
    }
     
     /////////////////////////NOVOS METODOS///////////////////////////
     public List<Madeira> buscaCidadesEstado(String estado) {
        return this.madeiraDAO.buscaCidadesEstado(estado);
    }
     public List<String> listaEstados(){
         return this.madeiraDAO.listaEstados();
     }
     
     public List<String> listaCidades(){
         return this.madeiraDAO.listaCidades();
     }
     
     public List<String> listaEmpresas(){
         return this.madeiraDAO.listaEmpresas();
     }

  /*  public static class listar implements List<Madeira> {

        public listar() {
        }
    }*/
    
    
}
