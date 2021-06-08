package br.com.devmedia.curso.domain;

/*
 * classe enum são tipos de campos que consistem em um conjunto
 * fixo de constantes (static final)
 */
public enum TipoSexo {
	FEMININO('F'), MASCULINO('M');
	
	private char desc;

	public char getDesc() {
		return desc;
	}

	private TipoSexo(char desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
