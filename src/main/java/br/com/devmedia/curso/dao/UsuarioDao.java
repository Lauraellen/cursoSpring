package br.com.devmedia.curso.dao;

import java.util.List;

import br.com.devmedia.curso.domain.Usuario;

/*
 * interface que possui 5 métodos;
 * salvar e editar recebem como parametros o objeto usuario;
 * o método excluir recebe como paramento um id
 * 
 */

public interface UsuarioDao {
	
	void salvar (Usuario usuario);
	
	void editar (Usuario usuario);
	
	void excluir (Long id);
	
	// retorna o usuario especifico procurado
	Usuario getId(Long id);
	
	//método getAll retorna uma lista de usuários
	List<Usuario> getAll();

}
