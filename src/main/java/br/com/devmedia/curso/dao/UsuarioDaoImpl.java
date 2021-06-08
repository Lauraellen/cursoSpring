package br.com.devmedia.curso.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;

/*
 * nesta classe, temos uma lista estatica que armazena os usu�rios;
 * usamos a anota��o @Repository para indicar que � um bean gerenciavel
 */

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	private static List<Usuario> us;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
	// se a lista de usuarios for igual a null, adicionamos esses usu�rios
	private List<Usuario> createUserList() {
		if (us == null) {
			us = new LinkedList<>();
			us.add(new Usuario(System.currentTimeMillis()+1L, "Ana", "da Silva", LocalDate.of(1980, 04, 15), TipoSexo.FEMININO));
	        us.add(new Usuario(System.currentTimeMillis()+2L, "Luiz", "dos Santos", LocalDate.of(1994, 07, 20), TipoSexo.MASCULINO));
	        us.add(new Usuario(System.currentTimeMillis()+3L, "Mariana", "Mello", LocalDate.of(1989, 06, 3), TipoSexo.FEMININO));
	        us.add(new Usuario(System.currentTimeMillis()+4L, "Caren", "Pereira"));
	        us.add(new Usuario(System.currentTimeMillis()+5L, "Sonia", "Fagundes"));
	        us.add(new Usuario(System.currentTimeMillis()+6L, "Norberto", "de Souza"));
			
		}
		return us;
	}
	
	// m�todo para salvar um novo usuario sendo seu id a hora exata q foi feito
	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		us.add(usuario);
	}
	

	/* m�todo para editar
	 * usamos a fun��o strem do java para filtrar se o id do usu�rio � igual (equals)
	 * o id de algum usuario, e depois um foreach para encontrar esse usuario e setar
	 * o nome e sobrenome
	 */
	
	@Override
	public void editar(Usuario usuario) {
		us.stream()
		.filter((u) -> u.getId().equals(usuario.getId()))
		.forEach((u) -> {
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setDtNascimento(usuario.getDtNascimento());
			u.setSexo(usuario.getSexo());
		});
	}
	
	/*
	 * esse m�todo excluir tem como parametro o id do usuario
	 * usa-se uma fun��o lambda para fazer a remo��o
	 */
	@Override
	public void excluir(Long id) {
	    us.removeIf((u) -> u.getId().equals(id));
	}

	/*
	 * procura pelo usuario que possui o mesmo id
	 */
	@Override
	public Usuario getId(Long id) {
		return us.stream()
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}
	
	// retorna uma lista de todos os usuarios
	@Override
	public List<Usuario> getAll() {
		return us;
	}
}
