/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.lenha;

import java.util.List;

/**
 *
 * @author Root
 */
public interface LenhaDAO {
     public void salvar(Madeira madeira);

	public void atualizar(Madeira madeira);

	public void excluir(Madeira madeira);

	public Madeira carregar(Integer codigo);

	public Madeira buscarPorId(Integer id);

	public List<Madeira> listar(); 
        
        public long buscaTotalMadeira(String madeira);
        public long buscaTotalEstado(String estado);
        
        public long buscaTotalCidade(String cidade);
        
        public Madeira buscarPorCNPJ(String cnpj);
        //public long buscaTotalCidade(String cidade);
        
        ////////////////NOVOS METODOS////////////////////
          public List<Madeira> buscaCidadesEstado(String estado);
         public List<String> listaEstados();
        
        public List<String> listaCidades();
        
        public List<String> listaEmpresas();
}
