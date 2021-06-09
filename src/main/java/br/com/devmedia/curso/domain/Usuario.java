package br.com.devmedia.curso.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Usuario {
	/*
	 * Depois q adicionamos a dependencia de hibernate-validator no pom
	 * podemos colcoar asa anotações de validação.
	 */
	
	private Long id;
	
	/*
	 * a anotação notBlank adiciona uma validação de que não é possivel o campo nome estar em branco;
	 * a anotação size limita o tamanho do campo
	 * 
	 */
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo obrigatório entre {min} e {max} caracteres.")
	private String sobrenome;
	
	private TipoSexo sexo;
	
	/*
	 * Essa anotação transforma o retorno que vem como string, em um objeto.
	 * Pois o spring espera um objeto
	 */
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "O campo data de nascimento é obrigatório.")
	private LocalDate dtNascimento;
	
	//método construtor padrão, pois quando trabalhamos com spring MVC, 
	//é obrigatorio ter esse método
	public Usuario() {
		super();
	}
	
	//dois métodos construtor, pois pode ou não ter a data preenchida
	//método construtor 
	public Usuario(Long id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	//método construtor 
	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
	}


	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento, TipoSexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Usuario "
				+ "[id=" + id + ", "
				+ "nome=" + nome + ", "
				+ "sobrenome=" + sobrenome + "]";
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
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

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}
	
	

}
