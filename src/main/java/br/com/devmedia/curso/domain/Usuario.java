package br.com.devmedia.curso.domain;

public class Usuario {
	
	private Long id;
	private String nome;
	private String sobrenome;
	
	//m�todo construtor padr�o, pois quando trabalhamos com spring MVC, 
	//� obrigatorio ter esse m�todo
	public Usuario() {
		super();
	}
	
	//m�todo construtor 
	public Usuario(Long id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	
	@Override
	public String toString() {
		return "Usuario "
				+ "[id=" + id + ", "
				+ "nome=" + nome + ", "
				+ "sobrenome=" + sobrenome + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	

}
