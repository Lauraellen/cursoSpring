package br.com.devmedia.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.devmedia.curso.domain.TipoSexo;

/*
 * essa interface Converter é do próprio spring;
 * passamos primeiro o tipo que ta vindo da página (String)
 * e em segundo o tipo que estamos esperando (TipoSexo)
 */
public class TipoSexoConverter implements Converter<String, TipoSexo> {

	/*
	 * Quando a solicitaçãochegar no controller, esse método deve ser chamado
	 * a conversão é realizada.
	 */
	@Override
	public TipoSexo convert(String texto) {
		char tipo = texto.charAt(0);
		
		// se tipo for feminino for igual ao TipoSexo feminino, converte para TipoSexo.feminino
		// senão converte para masculino
		return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
	}

}
